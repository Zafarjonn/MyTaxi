package uz.unical.reduz.core.ui.utils.ktx

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.text.DecimalFormat
import java.text.NumberFormat

val Number.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )

val Number.dpi
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()

fun hideKeyboard(view: View?) {
    if (view == null) {
        return
    }
    try {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (!imm.isActive) {
            return
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    } catch (e: Exception) {
    }
}

fun Fragment.setStatusBarColor(color: Int, isLight: Boolean = false) {
    val window = this.requireActivity().window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    if (isLight) {
        var flags = requireView().systemUiVisibility
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        requireView().systemUiVisibility = flags
    }
    window.statusBarColor = ContextCompat.getColor(this.requireContext(), color)
}

fun Number?.moneyFormat(): String {
    val formatter: NumberFormat = DecimalFormat("#,###")
    return formatter.format(this ?: 0)
}

