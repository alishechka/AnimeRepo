package com.example.anime_chan.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface GenreIdDao {

    @Query("SELECT * FROM Genre_id")
    fun getGenres(): Single<List<GenreIdEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGenre(genre: List<GenreIdEntity>): Completable
}