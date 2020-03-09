package com.example.anime_chan.model

import com.google.gson.annotations.SerializedName

data class GenreSearchBase (

    @SerializedName("request_hash") val request_hash : String,
    @SerializedName("request_cached") val request_cached : Boolean,
    @SerializedName("request_cache_expiry") val request_cache_expiry : Int,
    @SerializedName("mal_url") val mal_url : Mal_url,
    @SerializedName("item_count") val item_count : Int,
    @SerializedName("manga") val manga : List<Manga>
)