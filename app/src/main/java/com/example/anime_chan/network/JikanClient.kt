package com.example.anime_chan.network

import com.example.anime_chan.ENDPOINT_SEARCH_GENRE
import com.example.anime_chan.ENDPOINT_SEARCH_MANGA
import com.example.anime_chan.ENDPOINT_SEASON_LATER
import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import com.example.anime_chan.model.seasonLater.SeasonLaterBase
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface JikanClient {

    // genre=anime/manga
    @GET("$ENDPOINT_SEARCH_GENRE/{type}/{genre_id}/{page}")
    fun searchByGenre(
        @Path("type") type: String = "manga",
        @Path("genre_id") genre_id: String,
        @Path("page") page: Int = 1
    ): Single<GenreSearchBase>

    @GET(ENDPOINT_SEARCH_MANGA)
    fun searchManga(@Query("q") search: String): Single<MangaSearchBase>

    @GET(ENDPOINT_SEASON_LATER)
    fun getSeasonLater(): Single<SeasonLaterBase>

}