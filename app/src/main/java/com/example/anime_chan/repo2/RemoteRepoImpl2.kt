package com.example.anime_chan.repo2

import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import com.example.anime_chan.network.JikanClient
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteRepoImpl2 @Inject constructor(private val remoteRepoClient: JikanClient) :
    RemoteRepo2 {

    override fun getMangaRepository(searchText:String): Single<MangaSearchBase> {
        return remoteRepoClient.searchManga(searchText)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}