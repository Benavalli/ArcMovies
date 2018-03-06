package com.benavalli.arcmovies.features.home.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.benavalli.arcmovies.R
import com.benavalli.arcmovies.application.ArcMovieApplication
import com.benavalli.arcmovies.base.BaseActivity
import com.benavalli.arcmovies.databinding.ActivityHomeBinding
import com.benavalli.arcmovies.di.component.DaggerHomeActivityComponent
import com.benavalli.arcmovies.di.component.HomeActivityComponent
import com.benavalli.arcmovies.domain.UpcomingMovies
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
        presenter.loadMovies()
    }

    override fun bindMovies(movies: UpcomingMovies) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
