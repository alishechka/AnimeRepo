package com.example.anime_chan.repo

import com.example.anime_chan.model.genreSearch.GenreSearchBase
import io.reactivex.Completable
import io.reactivex.Single

interface LocalRepo {

    fun getData(): Single<GenreSearchBase>

    fun addData(mangaList: GenreSearchBase): Completable
}