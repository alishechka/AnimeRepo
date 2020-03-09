package com.example.anime_chan.di

import com.example.anime_chan.FragmentGenreSearch
import dagger.Component
import javax.inject.Singleton

@Component(modules = [GenreAdapterModule::class])
@Singleton
interface GenreAdapterComponent {
    fun inject(fragmentGenreSearch: FragmentGenreSearch)

}