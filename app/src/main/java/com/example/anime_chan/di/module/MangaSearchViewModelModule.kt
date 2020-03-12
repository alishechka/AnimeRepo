package com.example.anime_chan.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.anime_chan.FragmentMangaSearch
import com.example.anime_chan.MangaSearchViewModel
import com.example.anime_chan.MangaSearchViewModelFactory
import com.example.anime_chan.db.JikanDao2
import com.example.anime_chan.di.ActivityScope
import com.example.anime_chan.network.JikanClient
import com.example.anime_chan.repo2.LocalRepoImpl2
import com.example.anime_chan.repo2.RemoteRepoImpl2
import com.example.anime_chan.repo2.Repository2
import com.example.anime_chan.repo2.RepositoryImpl2
import dagger.Module
import dagger.Provides

@Module
class MangaSearchViewModelModule(private val activity: FragmentMangaSearch) {

    @Provides
    @ActivityScope
    fun provideRepository(client: JikanClient, jikanDao2: JikanDao2): Repository2 {
        return RepositoryImpl2(RemoteRepoImpl2(client), LocalRepoImpl2(jikanDao2))
    }

    @Provides
    @ActivityScope
    fun provideFactory(repository: Repository2): MangaSearchViewModelFactory {
        return MangaSearchViewModelFactory(repository)
    }

    @Provides
    @ActivityScope
    fun getGenreViewModel(mangaSeachViewModelFactory: MangaSearchViewModelFactory): MangaSearchViewModel {
        return ViewModelProvider(activity, mangaSeachViewModelFactory).get(MangaSearchViewModel::class.java)
    }
}