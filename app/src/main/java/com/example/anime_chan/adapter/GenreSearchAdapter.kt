package com.example.anime_chan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_chan.FragmentDisplayByGenre
import com.example.anime_chan.R
import kotlinx.android.synthetic.main.genre_search_item.view.*

class GenreSearchAdapter(private val model: List<String>) :
    RecyclerView.Adapter<GenreSearchAdapter.GenreViewHolder>() {
//    val model: List<String> = CreateGenres().getGenreIds()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.genre_search_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.genreName.text = model[position]

        holder.genreName.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var fragment = FragmentDisplayByGenre()
                val activity = v?.context as AppCompatActivity

                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        })
    }

    class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val genreName = itemView.tv_genre
    }
}