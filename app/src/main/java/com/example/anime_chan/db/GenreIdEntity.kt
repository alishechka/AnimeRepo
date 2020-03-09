package com.example.anime_chan.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Genre_id")
data class GenreIdEntity(
    @PrimaryKey
    val genre: String,
    val key: Int
)