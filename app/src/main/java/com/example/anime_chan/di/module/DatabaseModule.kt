package com.example.anime_chan.di.module

import android.app.Application
import com.example.anime_chan.db.*
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
    fun provideDatabase3(): JikanDataBase3 {
        return JikanDataBase3.getInstance(application)
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
    @Provides
    @Singleton
    fun provideDao3(jikanDataBase: JikanDataBase3): JikanDao3 {
        return jikanDataBase.albumDao()
    }
}