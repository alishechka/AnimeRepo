package com.example.anime_chan.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import com.example.anime_chan.model.seasonLater.SeasonLaterBase
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface JikanDao3 {

    //need another one for Anime meh
    @Query("SELECT * FROM Season_Later")
    fun getAllSeasonLaterSearch(): Single<SeasonLaterBase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSeasonLaterSearch(seasonLater: SeasonLaterBase): Completable
}