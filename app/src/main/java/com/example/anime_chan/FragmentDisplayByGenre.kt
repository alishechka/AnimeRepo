package com.example.anime_chan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anime_chan.di.component.DaggerGenreViewModelComponent
import com.example.anime_chan.di.module.GenreViewModelModule
import kotlinx.android.synthetic.main.fragment_genre_search_result.*
import javax.inject.Inject

class FragmentDisplayByGenre : Fragment() {


    @Inject
    lateinit var viewModel: GenreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_genre_search_result, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerGenreViewModelComponent.builder()
            .appComponent((activity?.applicationContext as MyApp).component())
            .genreViewModelModule(GenreViewModelModule(this))
            .build().inject(this)

        val bundle = this.arguments
        if (bundle != null) {
            val genre = bundle.get("genre").toString()
            val genreId = bundle.get("genreId")
            tv_test.text =genre

        }




    }
}