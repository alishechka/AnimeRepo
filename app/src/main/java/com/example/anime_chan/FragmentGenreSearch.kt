package com.example.anime_chan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.anime_chan.di.component.AppComponent
import com.example.anime_chan.di.component.DaggerGenreViewModelComponent
import com.example.anime_chan.di.module.GenreAdapterModule
import com.example.anime_chan.di.module.GenreViewModelModule
import kotlinx.android.synthetic.main.fragment_genre_rv_search.*
import javax.inject.Inject

class FragmentGenreSearch : Fragment() {

    @Inject
    lateinit var model: List<String>
    @Inject
    lateinit var viewModel: GenreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_genre_rv_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerGenreViewModelComponent.builder()
            .appComponent((activity?.application as MyApp).component())
            .genreAdapterModule(GenreAdapterModule())
            .genreViewModelModule(GenreViewModelModule(this))
            .build().inject(this)


        rv_genre_search.adapter = GenreSearchAdapter(model)
        rv_genre_search.layoutManager = GridLayoutManager(this.context, 2)


    }

}