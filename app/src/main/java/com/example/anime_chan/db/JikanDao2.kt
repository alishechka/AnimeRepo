package com.example.anime_chan.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface JikanDao2 {

    //need another one for Anime meh
    @Query("SELECT*FROM MangaSeach")
    fun getAllMangaSearch(): Single<MangaSearchBase>

//    @Query("SELECT * FROM MangeBase WHERE manga=:mangaId")
//    fun getSpecificManga(mangaId: Int): Single<GenreSearchBase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMangaSearch(manga: MangaSearchBase): Completable
}