package com.example.anime_chan.repo

import com.example.anime_chan.model.GenreSearchBase
import com.example.anime_chan.model.Manga
import io.reactivex.Single

interface RemoteRepo {
    fun getGenreRepository(): Single<GenreSearchBase>
}