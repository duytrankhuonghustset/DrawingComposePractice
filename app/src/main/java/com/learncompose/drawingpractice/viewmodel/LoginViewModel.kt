package com.learncompose.drawingpractice.viewmodel

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learncompose.drawingpractice.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoginUiState(
    val account: String = "",
    val password: String = "",
    val isAccountError: Boolean = false,
    val isLoading: Boolean = false
)

sealed interface LoginUiEvent {
    data class ChangeAccount(val account: String): LoginUiEvent
    data class ChangePassword(val password: String): LoginUiEvent
    data object ClickLogin: LoginUiEvent
}

sealed interface LoginUiEffect {
    data class ShowSnackBar(@param:StringRes val messageRes: Int) : LoginUiEffect
    data object NavigateToHome : LoginUiEffect
}

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableStateFlow<LoginUiState> by lazy { MutableStateFlow(LoginUiState()) }
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _effect = Channel<LoginUiEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    companion object {
        private val PHONE_REGEX = Regex("""^0[35789]\d{8}$""")
        private val PASSWORD_REGEX = Regex("""^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,32}$""")
    }

    fun onEvent(uiEvent: LoginUiEvent) {
        when (uiEvent) {
            is LoginUiEvent.ChangeAccount -> {
                _uiState.update {
                    it.copy(account = uiEvent.account, isAccountError = false)
                }
            }

            is LoginUiEvent.ChangePassword -> {
                _uiState.update {
                    it.copy(password = uiEvent.password)
                }
            }

            is LoginUiEvent.ClickLogin -> {
                login()
            }
        }
    }

    private fun login() {
        val state = _uiState.value
        val isValidPhone = PHONE_REGEX.matches(state.account)
        val isValidPassword = PASSWORD_REGEX.matches(state.password)

        if (!isValidPhone) {
            _uiState.update {
                it.copy(isAccountError = true)
            }
            return
        }

        if (!isValidPassword) {
            viewModelScope.launch {
                _effect.send(LoginUiEffect.ShowSnackBar(R.string.login_password_invalid))
            }
            return
        }

        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            _effect.send(LoginUiEffect.NavigateToHome)
        }
    }

}