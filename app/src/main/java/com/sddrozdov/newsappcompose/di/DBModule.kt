package com.sddrozdov.newsappcompose.di

import android.content.Context
import androidx.room.Room
import com.sddrozdov.newsappcompose.data.db.UserDB
import com.sddrozdov.newsappcompose.domain.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideUserDataBase(@ApplicationContext context: Context): UserDB {
        return Room.databaseBuilder(
            context,
            UserDB::class.java,
            "UserDB.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(userDB: UserDB): UserDao {
        return userDB.getUserDao()
    }
}