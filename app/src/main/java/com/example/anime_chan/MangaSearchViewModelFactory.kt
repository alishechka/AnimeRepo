package com.example.anime_chan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anime_chan.repo2.Repository2

class MangaSearchViewModelFactory(private val repo: Repository2) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MangaSearchViewModel(repo) as T
    }
}