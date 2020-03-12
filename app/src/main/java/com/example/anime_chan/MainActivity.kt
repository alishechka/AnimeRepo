package com.example.anime_chan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.anime_chan.byGenre.FragmentGenreSearch
import com.example.anime_chan.byMangaSearch.FragmentMangaSearch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val genreSearchFragment = FragmentGenreSearch()
        val mangaSearchFragment = FragmentMangaSearch()
        val seasonLaterFragment = FragmentSeasonLater()

        btn_genre_search.setOnClickListener { fragmentSelector(genreSearchFragment) }
        btn_manga_search.setOnClickListener { fragmentSelector(mangaSearchFragment) }
        btn_season_later.setOnClickListener { fragmentSelector(seasonLaterFragment) }

    }

    fun fragmentSelector(fragment: Fragment) {
        val transaction = manager.beginTransaction()

        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}