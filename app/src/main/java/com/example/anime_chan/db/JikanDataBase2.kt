package com.example.anime_chan.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.anime_chan.db.converter.*
import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase

@Database(entities = [MangaSearchBase::class], version = 2)
@TypeConverters(

    ListToObjectConverterResults::class
)
abstract class JikanDataBase2 : RoomDatabase() {

    abstract fun albumDao(): JikanDao2

    companion object {
        @Volatile
        private var INSTANCE: JikanDataBase2? = null

        fun getInstance(context: Context): JikanDataBase2 {
            synchronized(this) {
                var instance =
                    INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        JikanDataBase2::class.java,
                        "Jikan_Database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance

                }
                return instance
            }
        }
    }
}