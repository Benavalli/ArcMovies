package com.benavalli.arcmovies.features.home.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.benavalli.arcmovies.R
import com.benavalli.arcmovies.api.config.BuildConstants
import com.benavalli.arcmovies.application.ArcMovieApplication
import com.benavalli.arcmovies.base.BaseActivity
import com.benavalli.arcmovies.databinding.ActivityDetailsBinding
import com.benavalli.arcmovies.di.component.DaggerDetailsActivityComponent
import com.benavalli.arcmovies.di.component.DetailsActivityComponent
import com.benavalli.arcmovies.domain.MovieDetails
import com.benavalli.arcmovies.features.constants.IntentConstants
import com.benavalli.arcmovies.features.home.contract.DetailsActivityContract
import com.benavalli.arcmovies.features.home.presenter.DetailsActivityPresenter
import com.squareup.picasso.Picasso

class DetailsActivity : BaseActivity<DetailsActivityContract.View, DetailsActivityPresenter,
        DetailsActivityComponent>(), DetailsActivityContract.View {

    private lateinit var binding : ActivityDetailsBinding
    private var movieId: Int? = null

    override fun createComponent(): DetailsActivityComponent =
            DaggerDetailsActivityComponent.builder()
                    .applicationComponent(ArcMovieApplication.component).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        movieId = intent?.extras?.getInt(IntentConstants.DETAILS_INTENT_KEY)
        callLoadDetails(movieId)
    }

    private fun callLoadDetails(id: Int?) {
        id?.let {
            presenter.loadDetails(it)
        }
    }

    override fun bindDetails(details: MovieDetails) {
        binding.detailsTitle.text = details.name
        binding.detailsReleaseValue.text = details.releaseDate
        binding.detailsOverviewValue.text = details.overview
        binding.detailsGenresValue.text = details.genres.map { it.name }.joinToString(", ")
        Picasso.with(this).load(BuildConstants.BASE_IMAGE_POSTER_URL + details.poster)
                .into(binding.detailsBanner);

    }

}
