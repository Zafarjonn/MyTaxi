package uz.zafarbek.mytaxi.adapter

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import uz.zafarbek.mytaxi.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import uz.zafarbek.core.utils.ktx.OnActionListener

class OnboardingAdapter(private val context: Context) : PagerAdapter() {

    var onClickListener: OnActionListener<Int>? = null

    private val layouts = intArrayOf(
        R.layout.fragment_onboarding1,
        R.layout.fragment_onboarding2,
        R.layout.fragment_onboarding3,
        R.layout.fragment_onboarding4
    )

    override fun getCount(): Int {
        return layouts.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(layouts[position], container, false)
        view.findViewById<Button>(R.id.button2).setOnClickListener {
            onClickListener?.onAction(layouts[position])
        }
        view.tag = position
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}