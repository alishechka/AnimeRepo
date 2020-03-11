package com.example.anime_chan.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.anime_chan.db.converter.ListToObjectConverterAuthors
import com.example.anime_chan.db.converter.ListToObjectConverterGenres
import com.example.anime_chan.db.converter.ListToObjectConverterManga
import com.example.anime_chan.db.converter.ListToObjectConverterString
import com.example.anime_chan.model.GenreSearchBase
import com.example.anime_chan.model.Manga

@Database(entities = [GenreIdEntity::class, GenreSearchBase::class], version = 1)
@TypeConverters(
    ListToObjectConverterGenres::class,
    ListToObjectConverterAuthors::class,
    ListToObjectConverterString::class,
    ListToObjectConverterManga::class
)
abstract class JikanDataBase : RoomDatabase() {

    abstract fun albumDao(): JikanDao

    companion object {
        @Volatile
        private var INSTANCE: JikanDataBase? = null

        fun getInstance(context: Context): JikanDataBase {
            synchronized(this) {
                var instance =
                    INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        JikanDataBase::class.java,
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