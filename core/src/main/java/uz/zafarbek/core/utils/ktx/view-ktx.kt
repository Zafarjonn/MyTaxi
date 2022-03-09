package uz.zafarbek.core.utils.ktx

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.window.layout.WindowMetricsCalculator
import com.facebook.shimmer.ShimmerFrameLayout

fun Context.getScreenWH(): Point {
    val metrics = WindowMetricsCalculator.getOrCreate()
        .computeCurrentWindowMetrics(this as Activity)

    val widthDp = metrics.bounds.width() /
            resources.displayMetrics.density

    val heightDp = metrics.bounds.height() /
            resources.displayMetrics.density
    return Point(widthDp.toInt(), heightDp.toInt())
}
fun View?.visible() = this?.let {
    this.visibility = View.VISIBLE
}

fun View?.invisible() = this?.let {
    this.visibility = View.INVISIBLE
}

fun View?.gone() = this?.let {
    this.visibility = View.GONE
}

fun ViewGroup.inflater() = LayoutInflater.from(this.context)

fun Context.getResDrawable(@DrawableRes drawable: Int): Drawable? {
    return ContextCompat.getDrawable(this, drawable)
}


fun Context.getResColor(@ColorRes color: Int): Int {
    return ContextCompat.getColor(this, color)
}

val ViewGroup.inflate: LayoutInflater
    get() = LayoutInflater.from(context)

fun ShimmerFrameLayout.start() {
    this.isGone = false
    this.startShimmer()
}

fun ShimmerFrameLayout.stop() {
    this.isGone = true
    this.stopShimmer()
}

fun ViewGroup.inflate(): LayoutInflater = LayoutInflater.from(context)

fun ShimmerFrameLayout.isVisible(boolean: Boolean) {
    if (boolean) {
        start()
    } else {
        stop()
    }
}
