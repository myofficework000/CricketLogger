package com.android.cricketlogger.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.cricketlogger.local.entity.Player

@Dao
interface PlayerDAO {
    @Insert
    fun insert(player: Player)

    @Query("SELECT * FROM newplayertable")
    fun getAllPlayers(): List<Player>
}