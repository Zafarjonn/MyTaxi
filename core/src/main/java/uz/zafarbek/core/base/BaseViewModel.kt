package uz.zafarbek.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


abstract class BaseViewModel : ViewModel() {

    private val _navigationCommand = Channel<NavigationCommand>(capacity = 1)
    val navigationCommand = _navigationCommand.receiveAsFlow()
    fun navigate(navigationCommand: NavigationCommand) {
        viewModelScope.launch {
            _navigationCommand.send(navigationCommand)
        }
    }

    private val _showErrorMessage = Channel<String>(capacity = 1)
    val showErrorMessage = _showErrorMessage.receiveAsFlow()
    fun showErrorMessage(message: String) {
        viewModelScope.launch {
            _showErrorMessage.send(message)
        }
    }

    private val _back = Channel<Boolean>(capacity = 1)
    val back = _back.receiveAsFlow()
    fun back() {
        viewModelScope.launch {
            _back.send(true)
        }
    }

    val showLoading = MutableStateFlow(false)

}