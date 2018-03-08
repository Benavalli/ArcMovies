package com.benavalli.arcmovies.features.home.presenter

import android.util.Log
import com.benavalli.arcmovies.api.repository.HomeRepository
import com.benavalli.arcmovies.base.BasePresenter
import com.benavalli.arcmovies.domain.MovieDetails
import com.benavalli.arcmovies.features.home.contract.DetailsActivityContract
import javax.inject.Inject

class DetailsActivityPresenter
@Inject
constructor(private val repository: HomeRepository) : BasePresenter<DetailsActivityContract.View>(),
        DetailsActivityContract.Presenter<DetailsActivityContract.View> {

    override fun loadDetails(id: Int) {
        repository.getDetails(id)
                .subscribe({loadDetailsSuccess(it)}, {loadDetailsError(it)})
    }

    private fun loadDetailsSuccess(movieDetails : MovieDetails) {
        getView()?.bindDetails(movieDetails)
    }

    private fun loadDetailsError(throwable: Throwable) {
        Log.e("DetailsActivityPresenter", throwable.message);
    }

}