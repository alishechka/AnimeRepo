package com.example.anime_chan.db.converter

import androidx.room.TypeConverter
import com.example.anime_chan.model.Authors
import com.example.anime_chan.model.Genres
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ListToObjectConverterGenres {

    var gson = Gson()

    @TypeConverter
    fun fromGenresList(value: List<Genres>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Genres>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGenresList(value: String): List<Genres> {
        val gson = Gson()
        val type = object : TypeToken<List<Genres>>() {}.type
        return gson.fromJson(value, type)
    }




}