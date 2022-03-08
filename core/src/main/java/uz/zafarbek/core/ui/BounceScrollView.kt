package uz.zafarbek.core.ui

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.Interpolator
import androidx.core.widget.NestedScrollView
import uz.zafarbek.core.R

import kotlin.math.abs
import kotlin.math.pow


class BounceScrollView(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int
) :
    NestedScrollView(context, attrs, defStyleAttr) {
    private var isScrollHorizontally: Boolean
    private var mDamping: Float
    private var isIncrementalDamping: Boolean
    private var mBounceDelay: Long
    private var mTriggerOverScrollThreshold: Int
    private var isDisableBounce: Boolean
    private var mInterpolator: Interpolator
    private var mChildView: View? = null
    private var mStart = 0f
    private var mPreDelta = 0
    private var mOverScrolledDistance = 0F
    private var mAnimator: ObjectAnimator? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    override fun canScrollVertically(direction: Int): Boolean {
        return !isScrollHorizontally
    }

    override fun canScrollHorizontally(direction: Int): Boolean {
        return isScrollHorizontally
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        if (mChildView == null && childCount > 0 || mChildView !== getChildAt(0)) {
            mChildView = getChildAt(0)
        }
        return super.onInterceptTouchEvent(ev)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        if (mChildView == null || isDisableBounce) return super.onTouchEvent(ev)
        when (ev.actionMasked) {
            MotionEvent.ACTION_DOWN -> mStart = if (isScrollHorizontally) ev.x else ev.y
            MotionEvent.ACTION_MOVE -> {
                val now: Float = if (isScrollHorizontally) ev.x else ev.y
                val delta = mStart - now
                val dampingDelta = (delta / calculateDamping()).toInt()
                mStart = now
                var onePointerTouch = true
                if (mPreDelta <= 0 && dampingDelta > 0) {
                    onePointerTouch = false
                } else if (mPreDelta >= 0 && dampingDelta < 0) {
                    onePointerTouch = false
                }
                mPreDelta = dampingDelta
                if (onePointerTouch && canMove(dampingDelta)) {
                    mOverScrolledDistance += dampingDelta
                    if (isScrollHorizontally) {
                        mChildView?.translationX = -mOverScrolledDistance
                    } else {
                        mChildView?.translationY = -mOverScrolledDistance
                    }
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                mPreDelta = 0
                mOverScrolledDistance = 0F
                cancelAnimator()
                mAnimator = if (isScrollHorizontally) {
                    ObjectAnimator.ofFloat(mChildView, View.TRANSLATION_X, 0f)
                } else {
                    ObjectAnimator.ofFloat(mChildView, View.TRANSLATION_Y, 0f)
                }
                mAnimator!!.setDuration(mBounceDelay).interpolator = mInterpolator
                mAnimator!!.start()
            }
        }
        return super.onTouchEvent(ev)
    }

    private fun calculateDamping(): Float {
        if (mChildView == null) return 0F
        var ratio: Float = if (isScrollHorizontally) {
            abs(mChildView!!.translationX) * 1.0f / mChildView!!.measuredWidth
        } else {
            abs(mChildView!!.translationY) * 1.0f / mChildView!!.measuredHeight
        }
        ratio += 0.2f
        return if (isIncrementalDamping) {
            mDamping / (1.0f - ratio.toDouble().pow(2.0).toFloat())
        } else {
            mDamping
        }
    }

    private fun canMove(delta: Int): Boolean {
        return if (delta < 0) canMoveFromStart() else canMoveFromEnd()
    }

    private fun canMoveFromStart(): Boolean {
        return if (isScrollHorizontally) scrollX == 0 else scrollY == 0
    }

    private fun canMoveFromEnd(): Boolean {
        return if (isScrollHorizontally) {
            var offset: Int = (mChildView?.measuredWidth ?: 0) - width
            offset = if (offset < 0) 0 else offset
            scrollX == offset
        } else {
            var offset: Int = (mChildView?.measuredHeight ?: 0) - height
            offset = if (offset < 0) 0 else offset
            scrollY == offset
        }
    }

    private fun cancelAnimator() {
        if (mAnimator != null && mAnimator!!.isRunning) {
            mAnimator!!.cancel()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        cancelAnimator()
    }

    private class DefaultQuartOutInterpolator : Interpolator {
        override fun getInterpolation(input: Float): Float {
            return (1.0f - (1 - input).toDouble().pow(4.0)).toFloat()
        }
    }

    companion object {
        private const val DEFAULT_DAMPING_COEFFICIENT = 3.0f
        private const val DEFAULT_SCROLL_THRESHOLD = 20
        private const val DEFAULT_BOUNCE_DELAY: Long = 400
    }

    init {
        isVerticalScrollBarEnabled = false
        isHorizontalScrollBarEnabled = false
        isFillViewport = true
        overScrollMode = View.OVER_SCROLL_NEVER
        val a: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.BounceScrollView, 0, 0)
        mDamping = a.getFloat(R.styleable.BounceScrollView_damping, DEFAULT_DAMPING_COEFFICIENT)
        val orientation = a.getInt(R.styleable.BounceScrollView_scrollOrientation, 0)
        isScrollHorizontally = orientation == 1
        isIncrementalDamping = a.getBoolean(R.styleable.BounceScrollView_incrementalDamping, true)
        mBounceDelay = a.getInt(
            R.styleable.BounceScrollView_bounceDelay,
            DEFAULT_BOUNCE_DELAY.toInt()
        ).toLong()
        mTriggerOverScrollThreshold = a.getInt(
            R.styleable.BounceScrollView_triggerOverScrollThreshold,
            DEFAULT_SCROLL_THRESHOLD
        )
        isDisableBounce = a.getBoolean(R.styleable.BounceScrollView_disableBounce, false)
        val enable = a.getBoolean(R.styleable.BounceScrollView_nestedScrollingEnabled, true)
        a.recycle()
        isNestedScrollingEnabled = enable
        mInterpolator = DefaultQuartOutInterpolator()
    }
}