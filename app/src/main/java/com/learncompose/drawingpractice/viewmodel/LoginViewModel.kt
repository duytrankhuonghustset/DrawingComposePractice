package com.learncompose.drawingpractice.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class LoginUiState(
    val account: String = "",
    val password: String = "",
    val isAccountEmpty: Boolean? = null,
    val isPasswordEmpty: Boolean? = null,
    val isLoading: Boolean = false
)

sealed interface LoginUiEvent {
    data class ChangeAccount(val account: String): LoginUiEvent
    data class ChangePassword(val password: String): LoginUiEvent
    data object ClickLogin: LoginUiEvent
}

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableStateFlow<LoginUiState> by lazy { MutableStateFlow(LoginUiState()) }
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEvent(uiEvent: LoginUiEvent) {
        when (uiEvent) {
            is LoginUiEvent.ChangeAccount -> {

            }

            is LoginUiEvent.ChangePassword -> {

            }

            is LoginUiEvent.ClickLogin -> {

            }
        }
    }

}