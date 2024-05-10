package com.android.cricketlogger.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.android.cricketlogger.local.entity.Match


@Dao
interface MatchesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMatches(match: Match)


    @Query("SELECT * FROM MatchTable")
    fun getAllMatches():List<Match>

    @Update
    fun updateMatch(match: Match)

    @Delete
    fun deleteMatch(match: Match)
}