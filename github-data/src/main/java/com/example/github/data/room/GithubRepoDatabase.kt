package com.example.github.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [GithubRepoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GithubRepoDatabase: RoomDatabase() {
    abstract fun GithubRepoDao(): GithubRepoDao

    companion object {
        private var instance: GithubRepoDatabase? = null

        @Synchronized
        fun getInstance(context: Context): GithubRepoDatabase? {
            if (instance == null)
                synchronized(GithubRepoDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GithubRepoDatabase::class.java,
                        "githubRepoDatabase.db"
                    ).build()
                }
            return instance
        }
    }
}
