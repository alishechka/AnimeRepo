package com.example.anime_chan.model.seasonLater

import androidx.room.TypeConverters
import com.example.anime_chan.db.converter.ListToObjectConverterGenres
import com.example.anime_chan.db.converter.ListToObjectConverterString
import com.google.gson.annotations.SerializedName

data class Anime (

    @SerializedName("mal_id") val mal_id : Int,
    @SerializedName("url") val url : String,
    @SerializedName("title") val title : String,
    @SerializedName("image_url") val image_url : String,
    @SerializedName("synopsis") val synopsis : String,
    @SerializedName("type") val type : String,
    @SerializedName("airing_start") val airing_start : String,
    @SerializedName("episodes") val episodes : String,
    @SerializedName("members") val members : Int,
    @TypeConverters(ListToObjectConverterGenres::class)
    @SerializedName("genres") val genres : List<Genres>,
    @SerializedName("source") val source : String,
//    @TypeConverters(ListToObjectConverterString::class)
//    @SerializedName("producers") val producers : List<String>,
    @SerializedName("score") val score : String,
    @TypeConverters(ListToObjectConverterString::class)
    @SerializedName("licensors") val licensors : List<String>,
    @SerializedName("r18") val r18 : Boolean,
    @SerializedName("kids") val kids : Boolean,
    @SerializedName("continuing") val continuing : Boolean
)