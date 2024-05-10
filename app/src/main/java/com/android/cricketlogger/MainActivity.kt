package com.android.cricketlogger

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.cricketlogger.databinding.ActivityMainBinding
import com.android.cricketlogger.local.AppDatabase
import com.android.cricketlogger.local.dao.MatchesDao
import com.android.cricketlogger.local.entity.Match

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var matchesDao: MatchesDao
    private lateinit var appDatabase: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initDatabase()
        initViews()
    }
    private fun initViews() {
        with(binding) {
            startMatchBTN.setOnClickListener {
                val hostTeam = hostTeamET.text.toString()
                val visitorTeam = visitorTeamET.text.toString()
                val tossWonBy = getSelectedRadioButtonText(binding.hostRG)
                val optedTo = getSelectedRadioButtonText(binding.batBallRG)
                val oversStr = binding.oversET.text.toString()

                val overs = oversStr.toIntOrNull()

                if (hostTeam.isNotBlank() && visitorTeam.isNotBlank() && tossWonBy.isNotBlank() && optedTo.isNotBlank() && overs != null && overs > 0) {
                    val match = Match(
                        hostName = hostTeam,
                        visitorName = visitorTeam,
                        tossWonBy = tossWonBy,
                        optedTo = optedTo,
                        overs = overs
                    )
                    matchesDao.addMatches(match)

                    Toast.makeText(this@MainActivity, "Match details saved successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Please fill in all the details correctly",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    private fun getSelectedRadioButtonText(radioGroup: RadioGroup): String {
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        return if (selectedRadioButtonId != -1) {
            findViewById<RadioButton>(selectedRadioButtonId).text.toString()
        }
        else {
            ""
        }
    }
    private fun initDatabase(){
        appDatabase=AppDatabase.getInstance(this)
        matchesDao=appDatabase.matchesDao()
    }
}