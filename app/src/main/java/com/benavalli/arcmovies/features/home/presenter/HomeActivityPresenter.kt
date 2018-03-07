package com.benavalli.arcmovies.features.home.presenter

import android.content.Context
import android.util.Log
import com.benavalli.arcmovies.api.repository.HomeRepository
import com.benavalli.arcmovies.base.BasePresenter
import com.benavalli.arcmovies.domain.UpcomingMovies
import com.benavalli.arcmovies.features.home.contract.HomeActivityContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeActivityPresenter
@Inject
constructor(private val context: Context, private val repository: HomeRepository) : BasePresenter<HomeActivityContract.View>(),
        HomeActivityContract.Presenter<HomeActivityContract.View> {


    override fun loadMovies() {
        System.out.println("oi")
        repository.getMovies(1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({loadMoviesSuccess(it)},{loadMoviesError(it)} )
    }

    fun loadMoviesSuccess(movies : UpcomingMovies) {
        System.out.println("oi")

    }

    fun loadMoviesError(throwable: Throwable) {
        System.out.println("oi")

    }

   /* override fun loadThings() {
        Log.e("TestPresenter", ".loadThings()")
        getView()?.showThings()
    }*/
}
