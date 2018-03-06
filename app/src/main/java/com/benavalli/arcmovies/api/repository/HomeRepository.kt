package com.benavalli.arcmovies.api.repository

import com.benavalli.arcmovies.api.Endpoints
import com.benavalli.arcmovies.domain.MovieDetails
import com.benavalli.arcmovies.domain.UpcomingMovies
import io.reactivex.Observable

interface HomeRepository {
    fun getMovies(page: Int): Observable<UpcomingMovies>
    fun getDetails(id: Int): Observable<MovieDetails>
}

class HomeRepositoryImp(private val endpoint: Endpoints) : HomeRepository {

    override fun getMovies(page: Int): Observable<UpcomingMovies> =
            endpoint
                    .getUpcomingMovies(page)

    override fun getDetails(id: Int): Observable<MovieDetails>  =
            endpoint
                    .getMovieDetails(id)
}