package com.sddrozdov.newsappcompose.ui.screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sddrozdov.newsappcompose.ui.screen.state.RegisterScreenEvent
import com.sddrozdov.newsappcompose.ui.screen.state.RegisterScreenState

class RegisterScreenViewModel : ViewModel() {

    var state by mutableStateOf(RegisterScreenState())
        private set

    fun onEvent(event: RegisterScreenEvent) {
        state = when (event) {
            is RegisterScreenEvent.UsernameUpdated -> state.copy(username = event.newUsername)
            is RegisterScreenEvent.EmailUpdated -> state.copy(email = event.newEmail)
            is RegisterScreenEvent.PasswordUpdated -> state.copy(password = event.newPassword)
        }
    }
}