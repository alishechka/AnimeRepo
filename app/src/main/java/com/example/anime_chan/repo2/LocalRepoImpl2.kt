package com.example.anime_chan.repo2

import com.example.anime_chan.db.JikanDao2
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LocalRepoImpl2 @Inject constructor(private val jikanDao2: JikanDao2) : LocalRepo2 {

    override fun getData(): Single<MangaSearchBase> {
        return jikanDao2.getAllMangaSearch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun addData(mangaSearchList: MangaSearchBase): Completable {
        return jikanDao2.addMangaSearch(mangaSearchList)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}