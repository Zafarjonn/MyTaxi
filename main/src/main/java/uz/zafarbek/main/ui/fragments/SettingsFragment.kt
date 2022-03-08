package uz.zafarbek.main.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.core.utils.ktx.openWebPage
import uz.zafarbek.main.R
import uz.zafarbek.main.databinding.FragmentSettingsBinding
import uz.zafarbek.main.ui.adapter.SettingsAdapter


import uz.zafarbek.main.ui.enums.SettingsItems
import uz.zafarbek.main.ui.vm.MainViewModel

@AndroidEntryPoint
class SettingsFragment  : BaseFragment(R.layout.fragment_settings) {
    private var sAdapter= SettingsAdapter()
    override val viewModel: MainViewModel by viewModels()
    private val binding: FragmentSettingsBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycleSettings.adapter = sAdapter
        sAdapter.setListener(aListener)
    }
    private val aListener: (SettingsItems) -> Unit = { it: SettingsItems ->
        when (it) {
            SettingsItems.ABOUT_APP -> {
//                navigate(
//                    ProfileFragmentDirections.actionBottomProfileToWebFragment(
//                        "https://www.privacypolicygenerator.info/live.php?token=vgIjb6w79EbZynkKUhOTQDzHKMR91QXm",
//                        it.text
//                    )
//                )
            }
            SettingsItems.ABOUT_ORG -> {
//                navigate(
//                    ProfileFragmentDirections.actionBottomProfileToWebFragment(
//                        "https://www.privacypolicygenerator.info/live.php?token=vgIjb6w79EbZynkKUhOTQDzHKMR91QXm",
//                        it.text)
//                )
            }
            SettingsItems.FEEDBACK -> {
//                navigate(MainFragmentDirections.actionMainToFeedback())
                requireContext().openWebPage("https://t.me/Qurashboy_Erqulov")
            }
            SettingsItems.RATE_APP -> {
//                    startRating()
//                requireContext().openWebPage("https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}")
            }
            SettingsItems.TERMS_OF_USE -> {
//                navigate(
//                    ProfileFragmentDirections.actionBottomProfileToWebFragment(
//                        "https://www.privacypolicygenerator.info/live.php?token=vgIjb6w79EbZynkKUhOTQDzHKMR91QXm",
//                        it.text
//                    )
//                )
            }

            /*     SettingsItems.LANGUAGE -> {
     //                val languages = Language.values().map { it.text }.toTypedArray()
     //                BottomSheet.Builder(requireContext()).setItems(languages) { d, w ->
     //                    if (viewModel.setLanguage(Language.values()[w])) {
     //                        activity?.recreate()
     //                    }
     //                }.setDividers(true).show()
                     viewModel.goLanguageSettings()
                 }*/
            else -> {

            }
        }
    }
}