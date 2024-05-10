package com.android.cricketlogger.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.cricketlogger.local.dao.PlayerDao
import com.android.cricketlogger.local.entity.Match
import com.android.cricketlogger.local.entity.Player

@Database(entities = [Player::class, Match::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao


}