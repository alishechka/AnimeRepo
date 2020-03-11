package com.example.anime_chan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_chan.R
import com.example.anime_chan.model.Manga
import kotlinx.android.synthetic.main.genre_search_result_item.view.*

class GenreSearchResultAdapter(private val model: List<Manga>) :
    RecyclerView.Adapter<GenreSearchResultAdapter.ResultViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.genre_search_result_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.title.text = model[position].title
    }

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.tv_title
    }
}