package com.benavalli.arcmovies.features.home.presenter

import android.content.Context
import com.benavalli.arcmovies.base.BasePresenter
import com.benavalli.arcmovies.features.home.contract.DetailsActivityContract
import javax.inject.Inject

class DetailsActivityPresenter
@Inject
constructor(private val context: Context) : BasePresenter<DetailsActivityContract.View>(),
        DetailsActivityContract.Presenter<DetailsActivityContract.View> {

    override fun loadDetails(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}