package uz.zafarbek.main.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.core.utils.ktx.openWebPage
import uz.zafarbek.main.R
import uz.zafarbek.main.databinding.FragmentSettingsBinding
import uz.zafarbek.main.ui.adapter.HistoryAdapter


import uz.zafarbek.main.ui.enums.SettingsItems
import uz.zafarbek.main.ui.vm.MainViewModel

@AndroidEntryPoint
class HistoryFragment  : BaseFragment(R.layout.fragment_settings) {
    private var hAdapter= HistoryAdapter()
    override val viewModel: MainViewModel by viewModels()
    private val binding: FragmentSettingsBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.backButton.setOnClickListener {
//            findNavController().popBackStack()
//        }
//        binding.recycler.adapter = hAdapter
//        hAdapter.submitList(viewModel.courses)
    }

}