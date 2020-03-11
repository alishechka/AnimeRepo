package com.example.anime_chan.di.component

import com.example.anime_chan.byGenre.FragmentGenreSearch
import com.example.anime_chan.di.ActivityScope
import com.example.anime_chan.di.module.GenreAdapterModule
import dagger.Component

@Component(modules = [GenreAdapterModule::class])
@ActivityScope
interface GenreAdapterComponent {
    fun inject(fragmentGenreSearch: FragmentGenreSearch)


}