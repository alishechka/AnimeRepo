package com.example.anime_chan.db.converter

import androidx.room.TypeConverter
import com.example.anime_chan.model.Manga
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ListToObjectConverterManga {

    var gson = Gson()

    @TypeConverter
    fun fromMangaList(value: List<Manga>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Manga>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toMangaList(value: String): List<Manga> {
        val gson = Gson()
        val type = object : TypeToken<List<Manga>>() {}.type
        return gson.fromJson(value, type)
    }

}