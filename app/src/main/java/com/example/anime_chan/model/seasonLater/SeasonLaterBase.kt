package com.example.anime_chan.model.seasonLater

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.anime_chan.db.converter.ListToObjectConverterAnime
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Season_Later")
data class SeasonLaterBase(
    @PrimaryKey
    @SerializedName("request_hash") val request_hash: String,
    @SerializedName("request_cached") val request_cached: Boolean,
    @SerializedName("request_cache_expiry") val request_cache_expiry: Int,
    @SerializedName("season_name") val season_name: String,
    @SerializedName("season_year") val season_year: String,
    @TypeConverters(ListToObjectConverterAnime::class)
    @SerializedName("anime") val anime: List<Anime>
)