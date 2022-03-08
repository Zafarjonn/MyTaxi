package uz.zafarbek.core.utils.ktx

import android.view.View

fun interface OnActionListener<T> {
    fun onAction(data: T)
}

class SingleClickListener(private val delay: Long, private val click: (v: View) -> Unit) :
    View.OnClickListener {

    private var lastClick: Long = 0

    override fun onClick(v: View) {
        if (getLastClickTimeout() > delay) {
            lastClick = System.currentTimeMillis()
            click(v)
        }
    }

    private fun getLastClickTimeout(): Long {
        return System.currentTimeMillis() - lastClick
    }
}

fun View.singleClick(delay: Long = 1000L, l: (View) -> Unit) {
    setOnClickListener(SingleClickListener(delay, l))
}
