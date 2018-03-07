package com.benavalli.arcmovies.features.home.view

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.benavalli.arcmovies.R
import com.benavalli.arcmovies.application.ArcMovieApplication
import com.benavalli.arcmovies.base.BaseActivity
import com.benavalli.arcmovies.databinding.ActivityHomeBinding
import com.benavalli.arcmovies.di.component.DaggerHomeActivityComponent
import com.benavalli.arcmovies.di.component.HomeActivityComponent
import com.benavalli.arcmovies.domain.UpcomingMovies
import com.benavalli.arcmovies.features.adapter.MoviesAdapter
import com.benavalli.arcmovies.features.constants.IntentConstants
import com.benavalli.arcmovies.features.home.contract.HomeActivityContract
import com.benavalli.arcmovies.features.home.presenter.HomeActivityPresenter


class HomeActivity : BaseActivity<HomeActivityContract.View, HomeActivityPresenter,
        HomeActivityComponent>(), HomeActivityContract.View {

    private lateinit var binding : ActivityHomeBinding

    override fun createComponent(): HomeActivityComponent =
            DaggerHomeActivityComponent.builder()
                    .applicationComponent(ArcMovieApplication.component).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setSupportActionBar(binding.toolbar)
        presenter.loadMovies()
    }

    override fun bindMovies(movies: UpcomingMovies) {
        binding.moviesList.adapter = MoviesAdapter(this, ArrayList(movies.results))
        binding.loadButton.setOnClickListener{ presenter.loadMovies() }
        binding.moviesList.setOnItemClickListener { _, _, position, _ ->
            showDetails(movies.results[position].id)
        }
    }

    private fun showDetails(id: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(IntentConstants.DETAILS_INTENT_KEY, id)
        startActivity(intent)
    }

}