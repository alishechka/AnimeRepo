package com.example.anime_chan.repo2

import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import io.reactivex.Completable
import io.reactivex.Single

interface LocalRepo2 {
    fun getData(): Single<MangaSearchBase>

    fun addData(mangaList: MangaSearchBase): Completable
}