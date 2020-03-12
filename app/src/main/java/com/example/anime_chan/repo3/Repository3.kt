package com.example.anime_chan.repo3

import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import com.example.anime_chan.model.seasonLater.SeasonLaterBase
import io.reactivex.Completable
import io.reactivex.Single

interface Repository3 {

    fun makeRemoteCall(): Single<SeasonLaterBase>

    fun addToLocalDatabase(seasonLater: SeasonLaterBase): Completable

    fun getFromLocalDatabase(): Single<SeasonLaterBase>
}