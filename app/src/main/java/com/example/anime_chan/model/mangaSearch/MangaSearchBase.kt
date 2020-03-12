package com.example.anime_chan.model.mangaSearch

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.anime_chan.db.converter.ListToObjectConverterResults
import com.google.gson.annotations.SerializedName

@Entity(tableName = "MangaSeach")
data class MangaSearchBase(
    @PrimaryKey
    @SerializedName("request_hash") val request_hash: String,
    @SerializedName("request_cached") val request_cached: Boolean,
    @SerializedName("request_cache_expiry") val request_cache_expiry: Double,
    @TypeConverters(ListToObjectConverterResults::class)
    @SerializedName("results") val results: List<Results>,
    @SerializedName("last_page") val last_page: Int
)