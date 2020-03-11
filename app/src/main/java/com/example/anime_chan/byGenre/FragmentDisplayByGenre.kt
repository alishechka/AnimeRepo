package com.example.anime_chan.byGenre

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anime_chan.MyApp
import com.example.anime_chan.R
import com.example.anime_chan.adapter.GenreSearchResultAdapter
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
            val genreId = bundle.get("genreId").toString()

            viewModel.getRepo(isConnectedToInternet(),genreId)
            viewModel.getAlbumLiveDataSuccess().observe(viewLifecycleOwner, Observer {
                rv_genre_search_result.adapter = GenreSearchResultAdapter(it)
                rv_genre_search_result.layoutManager = LinearLayoutManager(this.context)
            })
            viewModel.getErrorObservable().observe(viewLifecycleOwner, Observer {
                tv_error.text=it
            })
        }
    }

    fun isConnectedToInternet(): Boolean {
        val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}