package com.example.anime_chan.bySeasonLater

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
import com.example.anime_chan.adapter.SeasonLaterAdapter
import com.example.anime_chan.di.component.DaggerSeasonLaterViewModelComponent
import com.example.anime_chan.di.module.SeasonLaterViewModelModule
import kotlinx.android.synthetic.main.fragment_season_later.*
import javax.inject.Inject

class FragmentSeasonLater : Fragment() {

    @Inject
    lateinit var viewModel: SeasonLaterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_season_later, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerSeasonLaterViewModelComponent.builder()
            .appComponent((activity?.applicationContext as MyApp).component())
            .seasonLaterViewModelModule(SeasonLaterViewModelModule(this))
            .build().inject(this)

        viewModel.getRepo(isConnectedToInternet())

        viewModel.getAlbumLiveDataSuccess().observe(viewLifecycleOwner, Observer {
            rv_season_later.adapter =
                SeasonLaterAdapter(it)
            rv_season_later.layoutManager = LinearLayoutManager(this.context)
        })
        viewModel.getErrorObservable().observe(viewLifecycleOwner, Observer {
            tv_error_season_later.text = it
        })

    }

    fun isConnectedToInternet(): Boolean {
        val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}