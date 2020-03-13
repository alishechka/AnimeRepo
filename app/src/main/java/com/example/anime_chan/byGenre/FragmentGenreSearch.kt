package com.example.anime_chan.byGenre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.anime_chan.R
import com.example.anime_chan.adapter.GenreSearchAdapter
import com.example.anime_chan.di.component.DaggerGenreAdapterComponent
import com.example.anime_chan.di.module.GenreAdapterModule
import com.example.anime_chan.onClickListener
import kotlinx.android.synthetic.main.fragment_genre_rv_search.*
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

        DaggerGenreAdapterComponent.builder()
            .genreAdapterModule(GenreAdapterModule())
            .build().inject(this)

        rv_genre_search.adapter = GenreSearchAdapter(model, this)
        rv_genre_search.layoutManager = GridLayoutManager(this.context, 2)
    }

    override fun itemClicked(position: Int) {
        var fragment = FragmentDisplayByGenre()
        val activity = this.activity
        val bundle = Bundle()
        //+1 for position to make it start at 1 and not index 0
        bundle.putString("genreId", (position + 1).toString())
        fragment.arguments = bundle

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)?.addToBackStack(null)?.commit()
    }

}