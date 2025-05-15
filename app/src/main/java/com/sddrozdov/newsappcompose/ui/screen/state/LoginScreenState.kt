package com.sddrozdov.newsappcompose.ui.screen.state

import com.sddrozdov.newsappcompose.util.Result

data class LoginScreenState(
    val email: String = "",
    val password: String = "",
    var loginResult: Result? = null
)

sealed class LoginScreenEvent {
    data class EmailUpdated(val newEmail: String) : LoginScreenEvent()
    data class PasswordUpdated(val newPassword: String) : LoginScreenEvent()
    data object LoginBtnClicked : LoginScreenEvent()
}