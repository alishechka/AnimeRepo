package com.example.anime_chan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import com.example.anime_chan.repo2.Repository2
import io.reactivex.disposables.CompositeDisposable

class MangaSearchViewModel(private val repo: Repository2) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val albumLiveDataSuccess = MutableLiveData<MangaSearchBase>()
    private val errorObservable = MutableLiveData<String>()

    fun getRepo(isConnected: Boolean,searchText:String) {
        val observable = if (isConnected) repo.makeRemoteCall(searchText) else repo.getFromLocalDatabase()
        compositeDisposable.add(
            observable.subscribe(
                { i -> albumLiveDataSuccess.value = i },
                { e -> errorObservable.value = e.message }
            )
        )

    }

    fun getAlbumLiveDataSuccess(): LiveData<MangaSearchBase> = albumLiveDataSuccess
    fun getErrorObservable(): LiveData<String> = errorObservable
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}