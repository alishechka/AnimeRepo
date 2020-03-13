package com.example.anime_chan.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.anime_chan.bySeasonLater.FragmentSeasonLater
import com.example.anime_chan.bySeasonLater.SeasonLaterViewModel
import com.example.anime_chan.bySeasonLater.SeasonLaterViewModelFactory
import com.example.anime_chan.db.JikanDao3
import com.example.anime_chan.di.ActivityScope
import com.example.anime_chan.network.JikanClient
import com.example.anime_chan.repo3.LocalRepoImpl3
import com.example.anime_chan.repo3.RemoteRepoImpl3
import com.example.anime_chan.repo3.Repository3
import com.example.anime_chan.repo3.RepositoryImpl3
import dagger.Module
import dagger.Provides

@Module
class SeasonLaterViewModelModule(private val activity: FragmentSeasonLater) {

    @Provides
    @ActivityScope
    fun provideRepository(client: JikanClient, jikanDao3: JikanDao3): Repository3 {
        return RepositoryImpl3(RemoteRepoImpl3(client), LocalRepoImpl3(jikanDao3))
    }

    @Provides
    @ActivityScope
    fun provideFactory(repository: Repository3): SeasonLaterViewModelFactory {
        return SeasonLaterViewModelFactory(
            repository
        )
    }

    @Provides
    @ActivityScope
    fun getGenreViewModel(seasonLaterViewModelFactory: SeasonLaterViewModelFactory): SeasonLaterViewModel {
        return ViewModelProvider(
            activity, seasonLaterViewModelFactory
        ).get(SeasonLaterViewModel::class.java)
    }
}