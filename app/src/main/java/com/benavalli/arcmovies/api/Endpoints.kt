package com.benavalli.arcmovies.api

import com.benavalli.arcmovies.domain.MovieDetails
import com.benavalli.arcmovies.domain.UpcomingMovies
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoints {

    @GET("discover/movie")
    fun getUpcomingMovies(@Query("page") page: Int) : Observable<UpcomingMovies>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int) : Observable<MovieDetails>

    @GET("search/movie")
    fun searchMovies(@Query("query", encoded = true) query: String) : Observable<UpcomingMovies>
}

