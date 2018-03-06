package com.benavalli.arcmovies.features.home.presenter

import android.content.Context
import android.util.Log
import com.benavalli.arcmovies.base.BasePresenter
import com.benavalli.arcmovies.features.home.contract.HomeActivityContract
import javax.inject.Inject

class HomeActivityPresenter
@Inject
constructor(private val context: Context) : BasePresenter<HomeActivityContract.View>(),
        HomeActivityContract.Presenter<HomeActivityContract.View> {

    override fun loadMovies() {

    }

   /* override fun loadThings() {
        Log.e("TestPresenter", ".loadThings()")
        getView()?.showThings()
    }*/
}
