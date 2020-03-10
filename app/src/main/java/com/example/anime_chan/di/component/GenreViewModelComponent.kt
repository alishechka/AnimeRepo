package com.example.anime_chan.di.component

import com.example.anime_chan.FragmentDisplayByGenre
import com.example.anime_chan.FragmentGenreSearch
import com.example.anime_chan.di.ActivityScope
import com.example.anime_chan.di.module.GenreAdapterModule
import com.example.anime_chan.di.module.GenreViewModelModule
import dagger.Component

@Component(modules = [GenreViewModelModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface GenreViewModelComponent {

    fun inject(fragmentDisplayByGenre: FragmentDisplayByGenre)

}