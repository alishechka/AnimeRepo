package com.example.anime_chan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_chan.R
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import kotlinx.android.synthetic.main.manga_search_item.view.*

class MangaSearchAdapter(private val model: MangaSearchBase) :
    RecyclerView.Adapter<MangaSearchAdapter.MangaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.manga_search_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return model.results.size
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.result.text = model.results[position].title
    }

    class MangaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val result = itemView.tv_manga_search_result
    }
}