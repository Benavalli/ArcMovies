package com.benavalli.arcmovies.features.home.presenter

import android.content.Context
import android.util.Log
import com.benavalli.arcmovies.api.repository.HomeRepository
import com.benavalli.arcmovies.base.BasePresenter
import com.benavalli.arcmovies.domain.UpcomingMovies
import com.benavalli.arcmovies.features.home.contract.HomeActivityContract
import javax.inject.Inject

class HomeActivityPresenter
@Inject
constructor(private val context: Context, private val repository: HomeRepository) : BasePresenter<HomeActivityContract.View>(),
        HomeActivityContract.Presenter<HomeActivityContract.View> {

    private var page : Int = 0

    override fun loadMovies() {
        repository.getMovies(++page)
                .subscribe({loadMoviesSuccess(it)}, {callError(it)})
    }

    override fun searchMovies(query: String) {
        repository.searchMovie(query)
                .subscribe({searchMoviesSuccess(it)}, {callError(it)})
    }

    private fun searchMoviesSuccess(movies : UpcomingMovies) {
        movies.results?.let {
            getView()?.bindSearch(movies)
        } ?: run {
            getView()?.emptySearch()
        }
    }

    private fun loadMoviesSuccess(movies : UpcomingMovies) {
        getView()?.bindMovies(movies)
    }

    private fun callError(throwable: Throwable) {
        Log.e("HomeActivityPresenter", throwable.message);
    }

}
