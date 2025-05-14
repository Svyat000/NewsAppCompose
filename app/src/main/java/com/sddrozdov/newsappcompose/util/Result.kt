package com.sddrozdov.newsappcompose.util

sealed interface Result {
    data class Success(val message: String = "") :
        com.sddrozdov.newsappcompose.util.Result

    data class Failure(val message: String = "") :
        com.sddrozdov.newsappcompose.util.Result
}