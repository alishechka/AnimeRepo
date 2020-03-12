package com.example.anime_chan.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.anime_chan.db.converter.ListToObjectConverterAnime
import com.example.anime_chan.db.converter.ListToObjectConverterGenres
import com.example.anime_chan.db.converter.ListToObjectConverterString
import com.example.anime_chan.model.seasonLater.SeasonLaterBase

@Database(entities = [SeasonLaterBase::class], version = 1)
@TypeConverters(
    ListToObjectConverterAnime::class,
    ListToObjectConverterGenres::class,
    ListToObjectConverterString::class
)
abstract class JikanDataBase3 : RoomDatabase() {

    abstract fun albumDao(): JikanDao3

    companion object {
        @Volatile
        private var INSTANCE: JikanDataBase3? = null

        fun getInstance(context: Context): JikanDataBase3 {
            synchronized(this) {
                var instance =
                    INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        JikanDataBase3::class.java,
                        "Jikan_Database3"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance

                }
                return instance
            }
        }
    }
}