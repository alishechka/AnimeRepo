package com.example.anime_chan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anime_chan.repo.Repository

class GenreViewModelFactory(private val repo:Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GenreViewModel(repo) as T
    }
}