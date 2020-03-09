package com.example.anime_chan.model

import com.google.gson.annotations.SerializedName

data class Manga (

    @SerializedName("mal_id") val mal_id : Int,
    @SerializedName("url") val url : String,
    @SerializedName("title") val title : String,
    @SerializedName("image_url") val image_url : String,
    @SerializedName("synopsis") val synopsis : String,
    @SerializedName("type") val type : String,
    @SerializedName("publishing_start") val publishing_start : String,
    @SerializedName("volumes") val volumes : Int,
    @SerializedName("members") val members : Int,
    @SerializedName("genres") val genres : List<Genres>,
    @SerializedName("authors") val authors : List<Authors>,
    @SerializedName("score") val score : Double,
    @SerializedName("serialization") val serialization : List<String>
)