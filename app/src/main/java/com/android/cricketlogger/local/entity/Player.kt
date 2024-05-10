package com.android.cricketlogger.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PlayerTable")
data class Player(
    @PrimaryKey(autoGenerate = true) val id:Int =0,
    val name: String
)
