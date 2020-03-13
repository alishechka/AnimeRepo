package com.example.anime_chan.repo3

import com.example.anime_chan.model.seasonLater.SeasonLaterBase
import com.example.anime_chan.network.JikanClient
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteRepoImpl3 @Inject constructor(private val remoteRepoClient: JikanClient) :
    RemoteRepo3 {

    override fun getSeasonLaterRepository(): Single<SeasonLaterBase> {
        return remoteRepoClient.getSeasonLater()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}