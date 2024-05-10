package com.android.cricketlogger

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.cricketlogger.databinding.ItemPlayerBinding
import com.android.cricketlogger.local.entity.NewPlayer

class PlayerAdapter(private val players: List<NewPlayer>):
    RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {
        private lateinit var binding: ItemPlayerBinding
    inner class PlayerViewHolder(private val binding: ItemPlayerBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(player: NewPlayer) {
            binding.apply {
                textName.text = player.name
                textMatches.text = player.matches.toString()
                textInnings.text = player.innings.toString()
                textRuns.text = player.runs.toString()
                textNotOuts.text = player.notOuts.toString()
                textBestScore.text = player.bestScore.toString()
                textStrikeRate.text = player.strikeRate.toString()
                textAverage.text = player.average.toString()
                textFours.text = player.fours.toString()
                textSixes.text = player.sixes.toString()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerAdapter.PlayerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPlayerBinding.inflate(inflater, parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerAdapter.PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.bind(player)
    }

    override fun getItemCount(): Int = players.size
}