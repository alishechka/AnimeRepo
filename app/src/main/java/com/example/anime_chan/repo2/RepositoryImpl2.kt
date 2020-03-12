package com.example.anime_chan.repo2

import com.example.anime_chan.model.genreSearch.GenreSearchBase
import com.example.anime_chan.model.mangaSearch.MangaSearchBase
import io.reactivex.Completable
import io.reactivex.Single

class RepositoryImpl2(private val remoteRepo: RemoteRepo2, private val localRepo: LocalRepo2) :
    Repository2 {
    override fun makeRemoteCall(searchText:String): Single<MangaSearchBase> {
        return remoteRepo.getMangaRepository(searchText)
            .doOnSuccess { i -> addToLocalDatabase(i) }

    }

    override fun addToLocalDatabase(mangaSearchBase: MangaSearchBase): Completable {
        return localRepo.addData(mangaSearchBase)
    }

    override fun getFromLocalDatabase(): Single<MangaSearchBase> {
        return localRepo.getData()
    }
}