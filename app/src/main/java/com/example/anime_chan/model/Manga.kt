package com.example.anime_chan.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.anime_chan.db.converter.ListToObjectConverterAuthors
import com.example.anime_chan.db.converter.ListToObjectConverterGenres
import com.example.anime_chan.db.converter.ListToObjectConverterString
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "Manga_table")
data class Manga(

//    @PrimaryKey
    @SerializedName("mal_id") val mal_id: Int,
    @SerializedName("url") val url: String,
    @SerializedName("title") val title: String,
    @SerializedName("image_url") val image_url: String,
    @SerializedName("synopsis") val synopsis: String,
    @SerializedName("type") val type: String,
    @SerializedName("publishing_start") val publishing_start: String,
    @SerializedName("volumes") val volumes: Int,
    @SerializedName("members") val members: Int,

    @TypeConverters(ListToObjectConverterGenres::class)
    @SerializedName("genres") val genres: List<Genres>,

    @TypeConverters(ListToObjectConverterAuthors::class)
    @SerializedName("authors") val authors: List<Authors>,
    @SerializedName("score") val score: Double,

    @TypeConverters(ListToObjectConverterString::class)
    @SerializedName("serialization") val serialization: List<String>
)