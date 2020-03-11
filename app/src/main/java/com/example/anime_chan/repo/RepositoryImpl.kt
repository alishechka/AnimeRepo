package com.example.anime_chan.repo

import com.example.anime_chan.model.GenreSearchBase
import io.reactivex.Completable
import io.reactivex.Single

class RepositoryImpl(private val remoteRepo: RemoteRepo, private val localRepo: LocalRepo) :
    Repository {
    override fun makeRemoteCall(genreId:String): Single<GenreSearchBase> {
        return remoteRepo.getGenreRepository(genreId)
            .doOnSuccess { i -> addToLocalDatabase(i) }

    }

    override fun addToLocalDatabase(mangaList: GenreSearchBase): Completable {
        return localRepo.addData(mangaList)
    }

    override fun getFromLocalDatabase(): Single<GenreSearchBase> {
        return localRepo.getData()
    }
}