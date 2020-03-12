package com.example.anime_chan.repo3

import com.example.anime_chan.db.JikanDao3
import com.example.anime_chan.model.seasonLater.SeasonLaterBase
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LocalRepoImpl3 @Inject constructor(private val jikanDao3: JikanDao3) : LocalRepo3 {

    override fun getData(): Single<SeasonLaterBase> {
        return jikanDao3.getAllSeasonLaterSearch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun addData(mangaSearchList: SeasonLaterBase): Completable {
        return jikanDao3.addSeasonLaterSearch(mangaSearchList)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}