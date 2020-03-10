package com.example.anime_chan.di.component

import com.example.anime_chan.FragmentGenreSearch
import com.example.anime_chan.di.ActivityScope
import com.example.anime_chan.di.module.GenreAdapterModule
import com.example.anime_chan.di.module.GenreViewModelModule
import dagger.Component

@Component(modules = [GenreViewModelModule::class,GenreAdapterModule::class],dependencies = [AppComponent::class])
@ActivityScope
interface GenreViewModelComponent {

    fun inject(fragmentGenreSearch: FragmentGenreSearch)
}