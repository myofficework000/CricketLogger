package com.android.cricketlogger.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.cricketlogger.local.entity.NewPlayer


@Dao
interface PlayerDAO {
    @Insert
    fun insert(player: NewPlayer)

    @Query("SELECT * FROM newplayertable")
    fun getAllPlayers(): List<NewPlayer>
}