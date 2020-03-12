package com.example.anime_chan.di.component

import com.example.anime_chan.FragmentSeasonLater
import com.example.anime_chan.byMangaSearch.FragmentMangaSearch
import com.example.anime_chan.di.ActivityScope
import com.example.anime_chan.di.module.MangaSearchViewModelModule
import com.example.anime_chan.di.module.SeasonLaterViewModelModule
import dagger.Component

@Component(modules = [SeasonLaterViewModelModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface SeasonLaterViewModelComponent {

    fun inject(fragmentSeasonLater: FragmentSeasonLater)
}