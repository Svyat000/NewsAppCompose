package com.sddrozdov.newsappcompose.ui.screen.state

import com.sddrozdov.newsappcompose.util.Result

data class RegisterScreenState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val registerResult: Result? = null
)

sealed class RegisterScreenEvent {
    data class UsernameUpdated(val newUsername: String) : RegisterScreenEvent()
    data class EmailUpdated(val newEmail: String) : RegisterScreenEvent()
    data class PasswordUpdated(val newPassword: String) : RegisterScreenEvent()
    data object RegisterBtnClicked : RegisterScreenEvent()
}