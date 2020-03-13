package com.example.anime_chan.model.seasonLater

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.anime_chan.db.converter.ListToObjectConverterAnime
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Season_Later")
data class SeasonLaterBase(
    @PrimaryKey
    @TypeConverters(ListToObjectConverterAnime::class)
    @SerializedName("anime") val anime: List<Anime>
)

data class Anime (
    @SerializedName("title") val title : String,
    @SerializedName("synopsis") val synopsis : String
)