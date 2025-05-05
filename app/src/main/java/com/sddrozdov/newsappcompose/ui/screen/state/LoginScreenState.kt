package com.sddrozdov.newsappcompose.ui.screen.state

data class LoginScreenState(
    val email: String = "",
    val password: String = "",
)

sealed class LoginScreenEvent {
    data class EmailUpdated(val newEmail: String) : LoginScreenEvent()
    data class PasswordUpdated(val newPassword: String) : LoginScreenEvent()
}