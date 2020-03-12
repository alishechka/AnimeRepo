package com.example.anime_chan.repo3

import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import com.example.anime_chan.model.seasonLater.SeasonLaterBase
import io.reactivex.Completable
import io.reactivex.Single

interface LocalRepo3 {
    fun getData(): Single<SeasonLaterBase>

    fun addData(seasonLater: SeasonLaterBase): Completable
}