package com.example.anime_chan.byGenre

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anime_chan.model.GenreSearchBase
import com.example.anime_chan.model.Manga
import com.example.anime_chan.repo.Repository
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class GenreViewModel(private val repo: Repository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val albumLiveDataSuccess = MutableLiveData<GenreSearchBase>()
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

    fun getAlbumLiveDataSuccess(): LiveData<GenreSearchBase> = albumLiveDataSuccess
    fun getErrorObservable(): LiveData<String> = errorObservable

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
