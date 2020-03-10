package com.example.anime_chan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.anime_chan.adapter.GenreSearchAdapter
import com.example.anime_chan.di.component.DaggerGenreAdapterComponent
import com.example.anime_chan.di.component.DaggerGenreViewModelComponent
import com.example.anime_chan.di.module.GenreAdapterModule
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

        genreSelector()

        DaggerGenreAdapterComponent.builder()
            .genreAdapterModule(GenreAdapterModule())
            .build().inject(this)


        rv_genre_search.adapter = GenreSearchAdapter(model)
        rv_genre_search.layoutManager = GridLayoutManager(this.context, 2)

        val intent = Intent(this.context, FragmentDisplayByGenre::class.java)

    }

    fun genreSelector() {
        btn_search_anime.setOnClickListener { tv_genre.text = "anime" }
        btn_search_manga.setOnClickListener { tv_genre.text = "manga" }

    }



}