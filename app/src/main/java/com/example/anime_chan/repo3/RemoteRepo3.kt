package com.example.anime_chan.repo3

import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import com.example.anime_chan.model.seasonLater.SeasonLaterBase
import io.reactivex.Single

interface RemoteRepo3 {
    fun getSeasonLaterRepository(): Single<SeasonLaterBase>
}