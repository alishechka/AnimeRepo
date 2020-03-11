package com.example.anime_chan.network

import com.example.anime_chan.ENDPOINT_SEARCH_GENRE
import com.example.anime_chan.model.GenreSearchBase
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface JikanClient {

    // genre=anime/manga
    @GET("$ENDPOINT_SEARCH_GENRE/{type}/{genre_id}/{page}")
    fun searchByGenre(
        @Path("type") type: String = "manga",
        @Path("genre_id") genre_id: String,
        @Path("page") page: Int = 1
    ): Single<GenreSearchBase>


}