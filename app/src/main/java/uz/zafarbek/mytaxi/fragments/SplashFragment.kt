package uz.zafarbek.mytaxi.fragments

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.unical.reduz.core.ui.utils.ktx.setStatusBarColor
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.core.base.NavigationCommand
import uz.zafarbek.mytaxi.R
import uz.zafarbek.mytaxi.databinding.FragmentSplashBinding
import uz.zafarbek.mytaxi.vm.AuthViewModel
import uz.zafarbek.navigation.Direction
import uz.zafarbek.navigation.ktx.navController

@AndroidEntryPoint
class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override val viewModel: AuthViewModel by viewModels()
    private val binding: FragmentSplashBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initGoogleAuth(requireActivity())

        viewLifecycleOwner.lifecycleScope.launch {
            val slideDownAnimation =
                AnimationUtils.loadAnimation(requireContext(), uz.zafarbek.core.R.anim.slide_down)
            val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), uz.zafarbek.core.R.anim.slide_up)
            binding.logo.startAnimation(slideDownAnimation)
            binding.appName.startAnimation(slideUpAnimation)
            viewModel.getHasSeenOnBoard()
            delay(4_000)
//            navController.navigate(Direction.Main)
//            return@launch
            if (!viewModel.isUserSignedIn(requireActivity())) {
                if (viewModel.hasSeenOnBoard.value == true) {
                    viewModel.navigate(NavigationCommand(SplashFragmentDirections.splashToAuth()))
                } else {
                    viewModel.navigate(NavigationCommand(SplashFragmentDirections.actionSplashFragmentToOnboardFragment()))
                }
            } else {
                navController.navigate(Direction.Main)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setStatusBarColor(uz.zafarbek.core.R.color.black_light)

    }

}