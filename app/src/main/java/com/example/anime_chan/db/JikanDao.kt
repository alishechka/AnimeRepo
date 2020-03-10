package com.example.anime_chan.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anime_chan.model.Manga
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface JikanDao {

    //need another one for Anime meh
    @Query("SELECT*FROM Manga_table")
    fun getAllGenreManga(): Single<List<Manga>>

    @Query("SELECT * FROM Manga_table WHERE mal_id=:mangaId")
    fun getSpecificManga(mangaId: Int): Single<Manga>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addManga(manga: List<Manga>): Completable
}