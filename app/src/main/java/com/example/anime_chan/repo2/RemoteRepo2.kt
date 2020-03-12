package com.example.anime_chan.repo2

import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import io.reactivex.Single

interface RemoteRepo2 {
    fun getMangaRepository(searchText:String): Single<MangaSearchBase>
}