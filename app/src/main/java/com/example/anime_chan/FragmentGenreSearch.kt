package com.example.anime_chan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.anime_chan.adapter.GenreSearchAdapter
import com.example.anime_chan.di.component.DaggerGenreAdapterComponent
import com.example.anime_chan.di.component.DaggerGenreViewModelComponent
import com.example.anime_chan.di.module.GenreAdapterModule
import kotlinx.android.synthetic.main.fragment_genre_rv_search.*
import kotlinx.android.synthetic.main.fragment_genre_search_result.*
import javax.inject.Inject

class FragmentGenreSearch : Fragment(), onClickListener {

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

        val genre = genreSelector()
        rv_genre_search.adapter = GenreSearchAdapter(model, this)
        rv_genre_search.layoutManager = GridLayoutManager(this.context, 2)

        btn_search_anime.setOnClickListener { tv_genre.text = "anime" }
        btn_search_manga.setOnClickListener { tv_genre.text = "manga" }

    }

    fun genreSelector(): String {

        when {
            btn_search_anime.isPressed -> {
                tv_genre.text = "anime"
                return "anime"
            }
            btn_search_manga.isPressed -> {
                tv_genre.text = "manga"
                return "manga"
            }
            else -> {
                return " "
            }
        }
//        btn_search_anime.setOnClickListener { tv_genre.text = "anime" }
//        btn_search_manga.setOnClickListener { tv_genre.text = "manga" }

    }

    override fun itemClicked(position: Int) {
        var fragment = FragmentDisplayByGenre()
        val activity = this.activity

        val bundle = Bundle()
        bundle.putString("genre", tv_genre.text.toString())
        bundle.putInt("genreId", position)
        fragment.arguments = bundle

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)?.addToBackStack(null)?.commit()
    }

}