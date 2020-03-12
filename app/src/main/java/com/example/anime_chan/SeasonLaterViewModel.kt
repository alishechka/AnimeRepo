package com.example.anime_chan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import com.example.anime_chan.model.seasonLater.SeasonLaterBase
import com.example.anime_chan.repo3.Repository3
import io.reactivex.disposables.CompositeDisposable

class SeasonLaterViewModel(private val repo: Repository3) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val albumLiveDataSuccess = MutableLiveData<SeasonLaterBase>()
    private val errorObservable = MutableLiveData<String>()

    fun getRepo(isConnected: Boolean) {
        val observable = if (isConnected) repo.makeRemoteCall() else repo.getFromLocalDatabase()
        compositeDisposable.add(
            observable.subscribe(
                { i -> albumLiveDataSuccess.value = i },
                { e -> errorObservable.value = e.message }
            )
        )

    }

    fun getAlbumLiveDataSuccess(): LiveData<SeasonLaterBase> = albumLiveDataSuccess
    fun getErrorObservable(): LiveData<String> = errorObservable

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}