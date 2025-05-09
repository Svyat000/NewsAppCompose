package com.sddrozdov.newsappcompose.ui.screen.state

data class RegisterScreenState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
)

sealed class RegisterScreenEvent{
    data class UsernameUpdated(val newUserName: String) : RegisterScreenEvent()
    data class EmailUpdated(val newEmail: String) : RegisterScreenEvent()
    data class PasswordUpdated(val newPassword: String) : RegisterScreenEvent()
}