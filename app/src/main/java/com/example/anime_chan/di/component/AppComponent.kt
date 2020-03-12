package com.example.anime_chan.di.component

import com.example.anime_chan.MyApp
import com.example.anime_chan.db.JikanDao
import com.example.anime_chan.db.JikanDao2
import com.example.anime_chan.di.module.DatabaseModule
import com.example.anime_chan.di.module.NetworkModule
import com.example.anime_chan.network.JikanClient
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, DatabaseModule::class])
@Singleton
interface AppComponent {
    fun inject(myApp: MyApp)
    fun client():JikanClient
    fun jikanDao(): JikanDao
    fun jikanDao2(): JikanDao2

}