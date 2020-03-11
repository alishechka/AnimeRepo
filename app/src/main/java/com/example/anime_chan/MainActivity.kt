package com.example.anime_chan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.anime_chan.byGenre.FragmentGenreSearch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val genreSearchFragment = FragmentGenreSearch()
        val mangaSearchFragment = FragmentMangaSearch()

        btn_genre_search.setOnClickListener { genreSearchFragment(genreSearchFragment) }
        btn_manga_search.setOnClickListener { genreSearchFragment(mangaSearchFragment) }


    }

    fun genreSearchFragment(fragment: Fragment) {
        val transaction = manager.beginTransaction()

        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}