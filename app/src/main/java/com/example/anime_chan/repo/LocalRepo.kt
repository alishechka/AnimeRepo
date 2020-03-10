package com.example.anime_chan.repo

import com.example.anime_chan.model.Manga
import io.reactivex.Completable
import io.reactivex.Single

interface LocalRepo {

    fun getData(): Single<List<Manga>>

    fun addData(mangaList: List<Manga>): Completable
}