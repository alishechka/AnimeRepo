package com.example.anime_chan.di.module

import android.app.Application
import com.example.anime_chan.db.JikanDao
import com.example.anime_chan.db.JikanDao2
import com.example.anime_chan.db.JikanDataBase
import com.example.anime_chan.db.JikanDataBase2
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
    fun provideDatabase2(): JikanDataBase2 {
        return JikanDataBase2.getInstance(application)
    }

    @Provides
    @Singleton
    fun provideDao(jikanDataBase: JikanDataBase): JikanDao {
        return jikanDataBase.albumDao()
    }
    @Provides
    @Singleton
    fun provideDao2(jikanDataBase: JikanDataBase2): JikanDao2 {
        return jikanDataBase.albumDao()
    }
}