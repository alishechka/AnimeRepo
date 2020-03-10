package com.example.anime_chan.db

import androidx.room.TypeConverter
import com.example.anime_chan.model.Authors
import com.example.anime_chan.model.Genres
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ListToObjectConverterString {

    var gson = Gson()

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }

}