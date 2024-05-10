package com.android.cricketlogger.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MatchTable")
data class Match(
    @PrimaryKey(autoGenerate = true) val matchId: Int = 0,
    val hostName: String,
    val visitorName: String,
    val tossWonBy: String,
    val optedTo: String,
    val overs: Int,
    @ColumnInfo(name = "matchDate")
    val matchDate: String? = null,
)
