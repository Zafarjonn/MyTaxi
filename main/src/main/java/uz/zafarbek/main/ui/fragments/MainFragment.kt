package uz.zafarbek.main.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.core.utils.ktx.composeAll
import uz.zafarbek.core.utils.ktx.openWebPage
import uz.zafarbek.main.R
import uz.zafarbek.main.databinding.FragmentMainBinding
import uz.zafarbek.main.ui.adapter.HomePagerAdapter
import uz.zafarbek.main.ui.enums.HomeType
import uz.zafarbek.main.ui.vm.MainViewModel

@AndroidEntryPoint
class MainFragment : BaseFragment(R.layout.fragment_main) {

    override val viewModel: MainViewModel by viewModels()
    private val binding: FragmentMainBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.layoutMain) {
            hamMenu.setOnClickListener {
                binding.root.open()
            }
            title.setOnClickListener {
                binding.root.open()
            }
        }
        setPager()
        with(binding.drawer) {
            share.setOnClickListener {
                requireContext().composeAll("")
            }
            settings.setOnClickListener {
                navigate(MainFragmentDirections.actionMainFragmentToSettingsFragment())
            }
            logOut.setOnClickListener {
                AlertDialog.Builder(requireContext()).setTitle(getString(R.string.log_out))
                    .setMessage(getString(R.string.log_out_message))
                    .setPositiveButton(getString(R.string.yes)) { d, w ->
//                    viewModel.logOut()
//                    val navOptions=NavOptions.Builder().setPopUpTo(R.id.bottom_profile,true).build()
//                    findNavController().navigate(R.id.loginFragment)
                        d.dismiss()
                    }.setNegativeButton(getString(R.string.cancel)) { d, w ->
                        d.dismiss()
                    }.show()
            }

            GoogleSignIn.getLastSignedInAccount(requireActivity())?.let {
                Glide.with(requireContext()).load(it.photoUrl).into(image)
                name.text = it.displayName
                mail.text = it.email
            }
        }

    }

    private fun setPager() {
        with(binding.layoutMain.pager) {
            adapter = HomePagerAdapter(this@MainFragment, HomeType.values())
            TabLayoutMediator(binding.layoutMain.tabs, this) { tab, position ->
                tab.text = getString(HomeType.values()[position].text)
                when (HomeType.values()[position]) {
                    HomeType.INDEX -> {

                    }

                    HomeType.DESCRIPTION -> {

                    }
                }
            }.attach()
        }
    }

}