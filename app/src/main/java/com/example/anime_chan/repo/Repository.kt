package com.example.anime_chan.repo

import com.example.anime_chan.model.GenreSearchBase
import com.example.anime_chan.model.Manga
import io.reactivex.Completable
import io.reactivex.Single

interface Repository {

    fun makeRemoteCall(): Single<GenreSearchBase>

    fun addToLocalDatabase(mangaList: GenreSearchBase): Completable

    fun getFromLocalDatabase(): Single<GenreSearchBase>
}