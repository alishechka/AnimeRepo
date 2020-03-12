package com.example.anime_chan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anime_chan.repo3.Repository3

class SeasonLaterViewModelFactory(private val repo: Repository3) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SeasonLaterViewModel(repo) as T
    }
}