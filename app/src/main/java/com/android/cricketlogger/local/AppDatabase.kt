package com.android.cricketlogger.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.cricketlogger.local.dao.MatchesDao
import com.android.cricketlogger.local.dao.PlayerDao
import com.android.cricketlogger.local.entity.Match
import com.android.cricketlogger.local.entity.Player

@Database(entities = [Player::class, Match::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao
    abstract fun matchesDao():MatchesDao

    companion object{
        private var appDatabaseInstance:AppDatabase?=null

        fun getInstance(context: Context):AppDatabase{
            appDatabaseInstance= Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "app_db"
            ).allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build()
            return appDatabaseInstance!!
        }
    }

}