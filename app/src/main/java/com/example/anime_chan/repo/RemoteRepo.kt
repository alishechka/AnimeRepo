package com.example.anime_chan.repo

import com.example.anime_chan.model.genreSearch.GenreSearchBase
import io.reactivex.Single

interface RemoteRepo {
    fun getGenreRepository(genreId:String): Single<GenreSearchBase>
}