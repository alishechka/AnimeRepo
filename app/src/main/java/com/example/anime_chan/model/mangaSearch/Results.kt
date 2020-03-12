package com.example.anime_chan.model.mangaSearch

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("mal_id") val mal_id: Int,
    @SerializedName("url") val url: String,
    @SerializedName("image_url") val image_url: String,
    @SerializedName("title") val title: String,
    @SerializedName("publishing") val publishing: Boolean,
    @SerializedName("synopsis") val synopsis: String,
    @SerializedName("type") val type: String,
    @SerializedName("chapters") val chapters: Int,
    @SerializedName("volumes") val volumes: Int,
    @SerializedName("score") val score: Double,
    @SerializedName("start_date") val start_date: String,
    @SerializedName("end_date") val end_date: String,
    @SerializedName("members") val members: Int
)