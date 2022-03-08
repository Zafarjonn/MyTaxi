package uz.zafarbek.mytaxi.vm

import android.app.Activity
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.zafarbek.core.base.BaseViewModel
import uz.zafarbek.domain.repositories.AuthRepository
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : BaseViewModel() {

    val hasSeenOnBoard = MutableStateFlow<Boolean?>(null)

    lateinit var mGoogleSignInClient: GoogleSignInClient
    private val gso: GoogleSignInOptions =
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestProfile()
            .build()

    fun initGoogleAuth(activity: Activity) {
        mGoogleSignInClient = GoogleSignIn.getClient(activity, gso);
    }

    fun isUserSignedIn(activity: Activity): Boolean {
        return GoogleSignIn.getLastSignedInAccount(activity) != null
    }

    fun setHasSeenOnboard(bool: Boolean) = viewModelScope.launch {
        repository.setHAsSeenOnBoarding(bool)
    }

    fun getHasSeenOnBoard() = repository.getHasSeenOnBoarding().onEach {
        hasSeenOnBoard.emit(it)
    }.launchIn(viewModelScope)

}