package com.android.cricketlogger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.cricketlogger.databinding.ActivityMainBinding
import com.android.cricketlogger.local.PlayerDatabase
import com.android.cricketlogger.local.dao.PlayerDAO
import com.android.cricketlogger.local.entity.NewPlayer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var playerDao: PlayerDAO
    private lateinit var playerDatabase: PlayerDatabase
    private lateinit var adapter: PlayerAdapter
    private lateinit var playerList: List<NewPlayer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initDatabase()
        initViews()
    }

    private fun initViews() {
        with(binding)
        {

            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)

            playerDao.insert(NewPlayer(name = "Player 1", matches = 10, innings = 8, runs = 500, notOuts = 2, bestScore = 100, strikeRate = 120.5, average = 50.5, fours = 60, sixes = 30))
            playerDao.insert(NewPlayer(name = "Player 2", matches = 8, innings = 7, runs = 450, notOuts = 1, bestScore = 90, strikeRate = 110.5, average = 60.2, fours = 50, sixes = 25))

            playerList = loadPlayers()

        }

    }

    private fun loadPlayers(): List<NewPlayer> {
        return playerDao.getAllPlayers()
    }

    private fun initDatabase() {
        playerDatabase = PlayerDatabase.getInstance(this)
        playerDao =playerDatabase.playerDao()
    }
}