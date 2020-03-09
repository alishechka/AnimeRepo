package com.example.anime_chan.di

import com.example.anime_chan.db.CreateGenres
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GenreAdapterModule {
    @Provides
    @Singleton
    fun getGenreSearchList(): List<String> {
        return CreateGenres().getGenreIds()
    }

}