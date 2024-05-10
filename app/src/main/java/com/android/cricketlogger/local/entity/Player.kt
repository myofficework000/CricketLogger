package com.android.cricketlogger.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PlayerTable")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val matches: Int,
    val innings: Int,
    val runs: Int,
    val notOuts: Int,
    val bestScore: Int,
    val strikeRate: Double,
    val average: Double,
    val fours: Int,
    val sixes: Int
)

