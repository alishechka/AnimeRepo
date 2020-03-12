package com.example.anime_chan.repo3

import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import com.example.anime_chan.model.seasonLater.SeasonLaterBase
import io.reactivex.Completable
import io.reactivex.Single

class RepositoryImpl3(private val remoteRepo: RemoteRepo3, private val localRepo: LocalRepo3) :
    Repository3 {

    override fun makeRemoteCall(): Single<SeasonLaterBase> {
        return remoteRepo.getSeasonLaterRepository()
            .doOnSuccess { i -> addToLocalDatabase(i) }

    }

    override fun addToLocalDatabase(seasonLater: SeasonLaterBase): Completable {
        return localRepo.addData(seasonLater)
    }

    override fun getFromLocalDatabase(): Single<SeasonLaterBase> {
        return localRepo.getData()
    }
}