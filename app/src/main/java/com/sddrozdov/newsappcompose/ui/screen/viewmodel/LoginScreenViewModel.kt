package com.sddrozdov.newsappcompose.ui.screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sddrozdov.newsappcompose.ui.screen.state.LoginScreenState

class LoginScreenViewModel : ViewModel() {

    var state by mutableStateOf(LoginScreenState())
    private set

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    fun updateEmail(email: String) {
        this.email = email
    }

    fun updatePassword(password: String) {
        this.password = password
    }
}