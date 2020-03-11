package com.example.anime_chan.db.converter

import androidx.room.TypeConverter
import com.example.anime_chan.model.genreSearch.Authors
import com.example.anime_chan.model.mangaSearch.Results
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ListToObjectConverterResults {

    var gson = Gson()



    @TypeConverter
    fun fromResultsList(value: List<Results>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Results>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toResultsList(value: String): List<Results> {
        val gson = Gson()
        val type = object : TypeToken<List<Results>>() {}.type
        return gson.fromJson(value, type)
    }


}