package com.example.anime_chan.repo

import com.example.anime_chan.model.GenreSearchBase
import io.reactivex.Single

interface RemoteRepo {
    fun getGenreRepository(): Single<GenreSearchBase>
}