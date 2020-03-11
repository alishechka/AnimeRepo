package com.example.anime_chan.model.mangaSearch

import com.google.gson.annotations.SerializedName

data class MangaSearchBase(

    @SerializedName("request_hash") val request_hash: String,
    @SerializedName("request_cached") val request_cached: Boolean,
    @SerializedName("request_cache_expiry") val request_cache_expiry: Int,
    @SerializedName("results") val results: List<Results>,
    @SerializedName("last_page") val last_page: Int
)