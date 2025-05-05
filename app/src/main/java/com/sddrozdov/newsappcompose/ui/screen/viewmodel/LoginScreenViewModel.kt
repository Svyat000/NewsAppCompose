package com.sddrozdov.newsappcompose.ui.screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sddrozdov.newsappcompose.ui.screen.state.LoginScreenEvent
import com.sddrozdov.newsappcompose.ui.screen.state.LoginScreenState

class LoginScreenViewModel : ViewModel() {

    var state by mutableStateOf(LoginScreenState())
        private set

    fun onEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.EmailUpdated -> this.state = state.copy(email = event.newEmail)
            is LoginScreenEvent.PasswordUpdated -> this.state = state.copy(password = event.newPassword)

        }
    }
}