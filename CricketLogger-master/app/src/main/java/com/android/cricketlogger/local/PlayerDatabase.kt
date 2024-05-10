package com.android.cricketlogger.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.cricketlogger.local.dao.PlayerDAO
import com.android.cricketlogger.local.entity.NewPlayer

@Database(entities = [NewPlayer::class], version = 1)
abstract class PlayerDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDAO

    companion object
    {
        private var appDatabaseInstance: PlayerDatabase? = null

        fun getInstance(context: Context): PlayerDatabase
        {
            appDatabaseInstance = Room.databaseBuilder(
                context,
                PlayerDatabase::class.java,
                "player_db"
            ).allowMainThreadQueries()
                .build()

            return appDatabaseInstance!!
        }
    }
}