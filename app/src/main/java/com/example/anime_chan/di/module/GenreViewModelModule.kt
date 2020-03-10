package com.example.anime_chan.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.anime_chan.FragmentDisplayByGenre
import com.example.anime_chan.FragmentGenreSearch
import com.example.anime_chan.GenreViewModel
import com.example.anime_chan.GenreViewModelFactory
import com.example.anime_chan.db.JikanDao
import com.example.anime_chan.di.ActivityScope
import com.example.anime_chan.network.JikanClient
import com.example.anime_chan.repo.LocalRepoImpl
import com.example.anime_chan.repo.RemoteRepoImpl
import com.example.anime_chan.repo.Repository
import com.example.anime_chan.repo.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class GenreViewModelModule(private val activity: FragmentDisplayByGenre) {

    @Provides
    @ActivityScope
    fun provideRepository(client: JikanClient, jikanDao: JikanDao): Repository {
        return RepositoryImpl(RemoteRepoImpl(client), LocalRepoImpl(jikanDao))
    }

    @Provides
    @ActivityScope
    fun provideFactory(repository: Repository): GenreViewModelFactory {
        return GenreViewModelFactory(repository)
    }

    @Provides
    @ActivityScope
    fun getGenreViewModel(genreViewModelFactory: GenreViewModelFactory): GenreViewModel {
        return ViewModelProvider(activity, genreViewModelFactory).get(GenreViewModel::class.java)
    }

}
