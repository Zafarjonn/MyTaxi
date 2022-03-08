package uz.zafarbek.core.utils.ktx

import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.Fragment
import es.dmoral.toasty.Toasty
import uz.zafarbek.core.R
import uz.zafarbek.core.base.BaseFragment

fun BaseFragment.toast(message: String?) {
    Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.errorToast(message: String) {
    val toast = Toasty.custom(
        requireContext(),
        message,
        R.drawable.ic_error,
        R.color.red,
        Toast.LENGTH_SHORT,
        true,
        true
    )
    toast.setGravity(Gravity.TOP, 0, 80)
    toast.show()
}

fun Fragment.successToast(message: String) {
    val toast = Toasty.custom(
        requireContext(),
        message,
        R.drawable.ic_success,
        R.color.green,
        Toast.LENGTH_SHORT,
        true,
        true
    )
    toast.setGravity(Gravity.TOP, 0, 80)
    toast.show()
}

fun Fragment.warningToast(message: String) {
    val toast = Toasty.custom(
        requireContext(),
        message,
        R.drawable.ic_warning,
        R.color.yellow,
        Toast.LENGTH_SHORT,
        true,
        true
    )
    toast.setGravity(Gravity.TOP, 0, 80)
    toast.show()
}