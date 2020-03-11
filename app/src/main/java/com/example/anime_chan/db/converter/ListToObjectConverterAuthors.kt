package com.example.anime_chan.db.converter

import androidx.room.TypeConverter
import com.example.anime_chan.model.Authors
import com.example.anime_chan.model.Genres
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ListToObjectConverterAuthors {

    var gson = Gson()



    @TypeConverter
    fun fromAuthorsList(value: List<Authors>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Authors>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toAuthorsList(value: String): List<Authors> {
        val gson = Gson()
        val type = object : TypeToken<List<Authors>>() {}.type
        return gson.fromJson(value, type)
    }


}