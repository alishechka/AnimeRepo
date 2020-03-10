package com.example.anime_chan.di.module

import com.example.anime_chan.db.CreateGenres
import com.example.anime_chan.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class GenreAdapterModule {
    @Provides
    @ActivityScope
    fun getGenreSearchList(): List<String> {
        return CreateGenres().getGenreIds()
    }

}