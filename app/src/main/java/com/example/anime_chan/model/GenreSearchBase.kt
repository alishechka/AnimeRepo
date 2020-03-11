package com.example.anime_chan.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.anime_chan.db.converter.ListToObjectConverterManga
import com.google.gson.annotations.SerializedName
@Entity(tableName = "MangeBase")
data class GenreSearchBase(

    @SerializedName("request_hash") val request_hash: String,
    @SerializedName("request_cached") val request_cached: Boolean,
    @SerializedName("request_cache_expiry") val request_cache_expiry: Int,
//    @SerializedName("mal_url") val mal_url: Mal_url,
    @SerializedName("item_count") val item_count: Int,
    @PrimaryKey
    @TypeConverters(ListToObjectConverterManga::class)
    @SerializedName("manga") val manga: List<Manga>
)