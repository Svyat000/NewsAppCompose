package com.sddrozdov.newsappcompose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sddrozdov.newsappcompose.domain.dao.UserDao
import com.sddrozdov.newsappcompose.domain.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDB : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}