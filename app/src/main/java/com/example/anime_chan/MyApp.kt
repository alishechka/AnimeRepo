package com.example.anime_chan

import android.app.Application
import com.example.anime_chan.di.component.AppComponent
import com.example.anime_chan.di.component.DaggerAppComponent
import com.example.anime_chan.di.module.DatabaseModule
import com.example.anime_chan.di.module.NetworkModule

class MyApp : Application() {


    override fun onCreate() {
        super.onCreate()
        component()

    }

    fun component(): AppComponent {
        return DaggerAppComponent.builder()
            .databaseModule(DatabaseModule(this))
            .networkModule(NetworkModule()).build()
    }
}