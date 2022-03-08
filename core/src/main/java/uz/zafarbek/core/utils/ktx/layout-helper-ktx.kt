package uz.zafarbek.core.utils.ktx

import android.content.Context
import android.widget.FrameLayout
import uz.unical.reduz.core.ui.utils.ktx.dp

const val MATCH_PARENT = -1
const val WRAP_CONTENT = -2

fun Context.getSize(size: Float): Int {
    return (if (size < 0) size else size.dp).toInt()
}

fun Context.createFrame(width: Int, height: Int, gravity: Int): FrameLayout.LayoutParams {
    return FrameLayout.LayoutParams(
        getSize(width.toFloat()),
        getSize(height.toFloat()),
        gravity
    )
}
