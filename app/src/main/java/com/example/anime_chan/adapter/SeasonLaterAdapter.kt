package com.example.anime_chan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_chan.R
import com.example.anime_chan.model.seasonLater.SeasonLaterBase
import kotlinx.android.synthetic.main.season_later_item.view.*

class SeasonLaterAdapter(private val model: SeasonLaterBase) :
    RecyclerView.Adapter<SeasonLaterAdapter.SeasonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        return SeasonViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.season_later_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return model.anime.size
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        holder.title.text = model.anime[position].title
        holder.synopsis.text=model.anime[position].synopsis
    }

    class SeasonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.tv_title_season_later
        val synopsis = itemView.tv_synopsis_season_later
    }
}