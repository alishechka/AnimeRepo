package com.example.anime_chan.network

import com.example.anime_chan.model.GenreSearchBase
import io.reactivex.Single

interface RemoteRepo {
    fun getRepo(): Single<GenreSearchBase>
}