package com.benavalli.arcmovies.features.home.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.benavalli.arcmovies.R
import com.benavalli.arcmovies.application.ArcMovieApplication
import com.benavalli.arcmovies.base.BaseActivity
import com.benavalli.arcmovies.databinding.ActivityHomeBinding
import com.benavalli.arcmovies.di.component.DaggerDetailsActivityComponent
import com.benavalli.arcmovies.di.component.DetailsActivityComponent
import com.benavalli.arcmovies.domain.MovieDetails
import com.benavalli.arcmovies.features.home.contract.DetailsActivityContract
import com.benavalli.arcmovies.features.home.presenter.DetailsActivityPresenter

class DetailsActivity : BaseActivity<DetailsActivityContract.View, DetailsActivityPresenter,
        DetailsActivityComponent>(), DetailsActivityContract.View {

    override fun bindDetails(details: MovieDetails) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var binding : ActivityHomeBinding

    override fun createComponent(): DetailsActivityComponent =
            DaggerDetailsActivityComponent.builder()
                    .applicationComponent(ArcMovieApplication.component).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
    }


}
