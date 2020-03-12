package com.example.anime_chan.di.component

import com.example.anime_chan.FragmentMangaSearch
import com.example.anime_chan.di.ActivityScope
import com.example.anime_chan.di.module.MangaSearchViewModelModule
import dagger.Component

@Component(modules = [MangaSearchViewModelModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface MangaSearchViewModelComponent {

    fun inject(fragmentMangaSearch: FragmentMangaSearch)
}