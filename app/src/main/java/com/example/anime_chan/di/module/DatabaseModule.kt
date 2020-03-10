package com.example.anime_chan.di.module

import android.app.Application
import com.example.anime_chan.db.JikanDao
import com.example.anime_chan.db.JikanDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideDatabase(): JikanDataBase {
        return JikanDataBase.getInstance(application)
    }

    @Provides
    @Singleton
    fun provideDao(jikanDataBase: JikanDataBase): JikanDao {
        return jikanDataBase.albumDao()
    }
}