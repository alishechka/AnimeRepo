package com.example.anime_chan.db.converter

import androidx.room.TypeConverter
import com.example.anime_chan.model.genreSearch.Manga
import com.example.anime_chan.model.seasonLater.Anime
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ListToObjectConverterAnime {

    var gson = Gson()

    @TypeConverter
    fun fromAnimeList(value: List<Anime>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Anime>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toAnimeList(value: String): List<Anime> {
        val gson = Gson()
        val type = object : TypeToken<List<Anime>>() {}.type
        return gson.fromJson(value, type)
    }

}