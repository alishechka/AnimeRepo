package com.example.anime_chan.model.seasonLater

import com.google.gson.annotations.SerializedName

data class Genres (

    @SerializedName("mal_id") val mal_id : Int,
    @SerializedName("type") val type : String,
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String
)