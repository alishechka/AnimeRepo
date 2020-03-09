package com.example.anime_chan.network

import com.example.anime_chan.model.GenreSearchBase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(private val remoteRepoClient: JikanClient) : RemoteRepo {

    override fun getRepo(): Single<GenreSearchBase> {
        return remoteRepoClient.searchByGenre("manga", 1, 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}