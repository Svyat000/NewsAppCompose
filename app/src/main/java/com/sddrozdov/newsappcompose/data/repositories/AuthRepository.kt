package com.sddrozdov.newsappcompose.data.repositories

import com.sddrozdov.newsappcompose.domain.dao.UserDao
import com.sddrozdov.newsappcompose.domain.models.User
import com.sddrozdov.newsappcompose.util.Result
import java.util.UUID
import javax.inject.Inject

class AuthRepository @Inject constructor(private val userDao: UserDao) {

    fun login(email: String, password: String): Result {
        val loginUser = userDao.login(email, password)
        val result = if (loginUser == null) Result.Failure("Ошибка, проверьте данные")
        else Result.Success("Успешно")
        return result
    }

    fun register(username: String, email: String, password: String): Result {
        if (userDao.getUserByEmail(email) != null)
            return Result.Failure("Email уже используется")
        val user = User(
            id = UUID.randomUUID().toString(),
            userName = username,
            email = email,
            password = password
        )
        userDao.addUser(user)
        return Result.Success("Регистрация успешна")
    }
}
