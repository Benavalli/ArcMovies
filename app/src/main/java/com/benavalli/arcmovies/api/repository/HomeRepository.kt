package com.benavalli.arcmovies.api.repository

import com.benavalli.arcmovies.api.Endpoints
import com.benavalli.arcmovies.domain.MovieDetails
import com.benavalli.arcmovies.domain.UpcomingMovies
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface HomeRepository {
    fun getMovies(page: Int): Observable<UpcomingMovies>
    fun getDetails(id: Int): Observable<MovieDetails>
}

class HomeRepositoryImp(private val endpoint: Endpoints) : HomeRepository {

    override fun getMovies(page: Int): Observable<UpcomingMovies> =
            endpoint
                    .getUpcomingMovies(page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    override fun getDetails(id: Int): Observable<MovieDetails>  =
            endpoint
                    .getMovieDetails(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

}