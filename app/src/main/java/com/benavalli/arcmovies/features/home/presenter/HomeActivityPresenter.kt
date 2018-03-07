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

    var page : Int = 1

    override fun loadMovies() {
        repository.getMovies(page)
                .subscribe({loadMoviesSuccess(it)}, {loadMoviesError(it)})
    }

    private fun loadMoviesSuccess(movies : UpcomingMovies) {
        getView()?.bindMovies(movies)
    }

    private fun loadMoviesError(throwable: Throwable) {
        Log.e("HomeActivityPresenter", throwable.message);
    }

}
