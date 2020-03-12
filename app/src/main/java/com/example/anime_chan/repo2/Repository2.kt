package com.example.anime_chan.repo2

import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import io.reactivex.Completable
import io.reactivex.Single

interface Repository2 {

    fun makeRemoteCall(searchText:String): Single<MangaSearchBase>

    fun addToLocalDatabase(mangaSearchBase: MangaSearchBase): Completable

    fun getFromLocalDatabase(): Single<MangaSearchBase>
}