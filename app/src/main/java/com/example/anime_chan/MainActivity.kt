package com.example.anime_chan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.anime_chan.byGenre.FragmentGenreSearch

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        genreSearchFragment()


    }

    fun genreSearchFragment() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentGenreSearch()

        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}