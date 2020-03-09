package com.example.anime_chan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_chan.db.CreateGenres
import com.example.anime_chan.di.DaggerGenreAdapterComponent
import com.example.anime_chan.di.GenreAdapterModule
import kotlinx.android.synthetic.main.fragment_genre_rv_search.*
import javax.inject.Inject

class FragmentGenreSearch : Fragment() {

    @Inject
    lateinit var model: List<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_genre_rv_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerGenreAdapterComponent.builder()
            .genreAdapterModule(GenreAdapterModule())
            .build().inject(this)

        rv_genre_search.adapter = GenreSearchAdapter(model)
        rv_genre_search.layoutManager = GridLayoutManager(this.context, 2)


    }
}