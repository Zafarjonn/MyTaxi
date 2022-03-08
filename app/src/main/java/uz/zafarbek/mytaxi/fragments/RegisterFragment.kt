package uz.zafarbek.mytaxi.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.core.utils.ktx.print
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.mytaxi.R
import uz.zafarbek.mytaxi.databinding.FragmentSignInBinding
import uz.zafarbek.mytaxi.vm.AuthViewModel
import uz.zafarbek.navigation.Direction
import uz.zafarbek.navigation.ktx.navController

@AndroidEntryPoint
class RegisterFragment : BaseFragment(R.layout.fragment_sign_in) {

    override val viewModel: AuthViewModel by viewModels()
    private val binding: FragmentSignInBinding by viewBinding()

    private val CONST_SIGN_IN = 13

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initGoogleAuth(requireActivity())

        viewModel.setHasSeenOnboard(true)

        binding.button2.setOnClickListener {
            val signInIntent = viewModel.mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, CONST_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CONST_SIGN_IN) {
            handleSignData(data)
        }
    }

    private fun handleSignData(data: Intent?) {
        // The Task returned from this call is always completed, no need to attach
        // a listener.
        GoogleSignIn.getSignedInAccountFromIntent(data)
            .addOnCompleteListener {
                "isSuccessful ${it.isSuccessful}".print()
                if (it.isSuccessful) {
                    // user successfully logged-in
                    "account ${it.result?.account}".print()
                    "displayName ${it.result?.displayName}".print()
                    "Email ${it.result?.email}".print()
                    navController.navigate(Direction.Main)
                } else {
                    // authentication failed
                    "exception ${it.exception}".print()
                }
            }

    }
}