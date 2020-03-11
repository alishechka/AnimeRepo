package com.example.anime_chan.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.anime_chan.db.converter.*
import com.example.anime_chan.model.genreSearch.GenreSearchBase

@Database(entities = [GenreIdEntity::class, GenreSearchBase::class], version = 1)
@TypeConverters(
    ListToObjectConverterGenres::class,
    ListToObjectConverterAuthors::class,
    ListToObjectConverterString::class,
    ListToObjectConverterManga::class,
    ListToObjectConverterResults::class
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