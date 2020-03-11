package com.example.anime_chan.model.genreSearch

import com.google.gson.annotations.SerializedName

data class Mal_url (

    @SerializedName("mal_id") val mal_id : Int,
    @SerializedName("type") val type : String,
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String
)