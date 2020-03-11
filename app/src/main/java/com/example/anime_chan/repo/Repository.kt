package com.example.anime_chan.repo

import com.example.anime_chan.model.genreSearch.GenreSearchBase
import io.reactivex.Completable
import io.reactivex.Single

interface Repository {

    fun makeRemoteCall(genreId:String): Single<GenreSearchBase>

    fun addToLocalDatabase(mangaList: GenreSearchBase): Completable

    fun getFromLocalDatabase(): Single<GenreSearchBase>
}