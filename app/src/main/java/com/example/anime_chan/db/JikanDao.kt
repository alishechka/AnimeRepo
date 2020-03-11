package com.example.anime_chan.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anime_chan.model.GenreSearchBase
import com.example.anime_chan.model.Manga
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface JikanDao {

    //need another one for Anime meh
    @Query("SELECT*FROM MangeBase")
    fun getAllGenreManga(): Single<GenreSearchBase>

//    @Query("SELECT * FROM MangeBase WHERE manga=:mangaId")
//    fun getSpecificManga(mangaId: Int): Single<GenreSearchBase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addManga(manga: GenreSearchBase): Completable
}