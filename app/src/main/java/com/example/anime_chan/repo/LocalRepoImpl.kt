package com.example.anime_chan.repo

import com.example.anime_chan.db.JikanDao
import com.example.anime_chan.model.Manga
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LocalRepoImpl @Inject constructor(private val jikanDao: JikanDao) : LocalRepo {
    override fun getData(): Single<List<Manga>> {
        return jikanDao.getAllGenreManga()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun addData(mangaList: List<Manga>): Completable {
        return jikanDao.addManga(mangaList)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}