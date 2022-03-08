package uz.zafarbek.mytaxi.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.core.base.NavigationCommand
import uz.zafarbek.core.utils.ktx.OnActionListener
import uz.zafarbek.mytaxi.R
import uz.zafarbek.mytaxi.adapter.OnboardingAdapter
import uz.zafarbek.mytaxi.adapter.OnboardingPageTransformer
import uz.zafarbek.mytaxi.databinding.FragmentOnboardBinding
import uz.zafarbek.mytaxi.vm.AuthViewModel

@AndroidEntryPoint
class OnboardFragment : BaseFragment(R.layout.fragment_onboard) {
    private var onboardingAdapter: OnboardingAdapter? = null
    private val binding: FragmentOnboardBinding by viewBinding()

    override val viewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeStatusbarTransparent()

        onboardingAdapter = OnboardingAdapter(requireContext())
        binding.onboardingViewPager.adapter = onboardingAdapter
        binding.onboardingViewPager.setPageTransformer(false, OnboardingPageTransformer())

        onboardingAdapter?.onClickListener = OnActionListener {
            nextPage()
        }
    }

    private fun nextPage() {
        if (binding.onboardingViewPager.currentItem < onboardingAdapter!!.count - 1) {
            binding.onboardingViewPager.setCurrentItem(
                binding.onboardingViewPager.currentItem + 1,
                true
            )
        } else {
            viewModel.navigate(NavigationCommand(OnboardFragmentDirections.actionOnboardFragmentToAuthFragment()))
        }
    }


    private fun makeStatusbarTransparent() {
        requireActivity().window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val window: Window = requireActivity().window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
    }
}