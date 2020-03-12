package com.example.anime_chan

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anime_chan.adapter.MangaSearchAdapter
import com.example.anime_chan.di.component.DaggerGenreViewModelComponent
import com.example.anime_chan.di.component.DaggerMangaSearchViewModelComponent
import com.example.anime_chan.di.module.GenreViewModelModule
import com.example.anime_chan.di.module.MangaSearchViewModelModule
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_manga_search.*
import javax.inject.Inject

class FragmentMangaSearch : Fragment() {

    @Inject
    lateinit var viewModel: MangaSearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_manga_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerMangaSearchViewModelComponent.builder()
            .appComponent((activity?.applicationContext as MyApp).component())
            .mangaSearchViewModelModule(MangaSearchViewModelModule(this))
            .build().inject(this)

        btn_search_manga_from_text.setOnClickListener {
            viewModel.getRepo(isConnectedToInternet(), et_search_manga.text.toString())
        }
        viewModel.getAlbumLiveDataSuccess().observe(viewLifecycleOwner, Observer {
            rv_manga_search.adapter=MangaSearchAdapter(it)
            rv_manga_search.layoutManager=LinearLayoutManager(this.context)
        })

        viewModel.getErrorObservable().observe(viewLifecycleOwner,Observer{
            tv_error_manga.text=it
//            Log.i(TAG,it)
        })

    }

    fun isConnectedToInternet(): Boolean {
        val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}