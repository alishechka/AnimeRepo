package com.example.anime_chan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anime_chan.model.Manga
import com.example.anime_chan.repo.Repository
import io.reactivex.disposables.CompositeDisposable

class GenreViewModel(private val repo: Repository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val albumLiveDataSuccess = MutableLiveData<List<Manga>>()
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

    fun getAlbumLiveDataSuccess(): LiveData<List<Manga>> = albumLiveDataSuccess
    fun getErrorObservable(): LiveData<String> = errorObservable

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
