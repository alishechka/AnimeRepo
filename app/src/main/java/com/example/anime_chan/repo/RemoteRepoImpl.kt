package com.example.anime_chan.repo

import com.example.anime_chan.model.GenreSearchBase
import com.example.anime_chan.network.JikanClient
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(private val remoteRepoClient: JikanClient) :
    RemoteRepo {

    override fun getGenreRepository(): Single<GenreSearchBase> {
        return remoteRepoClient.searchByGenre()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}