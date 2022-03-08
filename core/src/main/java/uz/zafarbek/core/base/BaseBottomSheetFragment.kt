package uz.zafarbek.core.base

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.zafarbek.core.R

abstract class BaseBottomSheetFragment(private val height: Int?) :
    BottomSheetDialogFragment() {

    override fun getTheme() = R.style.CustomBottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {
            (it as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
                ?.let { view ->
                    val layoutParams = view.layoutParams
                    layoutParams.height = height ?: WindowManager.LayoutParams.MATCH_PARENT
                    view.layoutParams = layoutParams
                }
        }
        return dialog
    }

}