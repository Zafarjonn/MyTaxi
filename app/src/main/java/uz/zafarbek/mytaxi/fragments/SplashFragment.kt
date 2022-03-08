package uz.zafarbek.mytaxi.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.core.base.NavigationCommand
import uz.zafarbek.mytaxi.R
import uz.zafarbek.mytaxi.vm.AuthViewModel
import uz.zafarbek.navigation.Direction
import uz.zafarbek.navigation.ktx.navController

@AndroidEntryPoint
class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override val viewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initGoogleAuth(requireActivity())

        viewLifecycleOwner.lifecycleScope.launch {
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

}