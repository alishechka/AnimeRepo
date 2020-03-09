package com.example.anime_chan.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GenreIdEntity::class], version = 1)
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