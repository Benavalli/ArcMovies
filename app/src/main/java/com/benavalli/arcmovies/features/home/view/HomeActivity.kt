package com.benavalli.arcmovies.features.home.view

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.SearchView
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
        verifyIntent(intent)
    }

    private fun verifyIntent(intent: Intent) {
        if (intent.action.equals(Intent.ACTION_SEARCH)) {
            var query = intent.getStringExtra(SearchManager.QUERY)
            presenter.searchMovies(query)
        }
        else {
            presenter.loadGenreList()
            presenter.loadMovies()
        }
    }

    override fun bindMovies(movies: UpcomingMovies) {
        binding.loadButton.visibility = View.VISIBLE
        binding.loadButton.setOnClickListener{ presenter.loadMovies() }
        setAdapterOnList(movies)
    }

    override fun bindSearch(movies: UpcomingMovies) {
        binding.loadButton.visibility = View.GONE
        setAdapterOnList(movies)
    }

    override fun emptySearch() {
        binding.loadButton.visibility = View.GONE
        binding.moviesList.visibility = View.GONE
        binding.emptySearch.visibility = View.VISIBLE
    }

    private fun setAdapterOnList(movies: UpcomingMovies) {
        binding.moviesList.adapter = MoviesAdapter(this, ArrayList(movies.results))
        binding.moviesList.setOnItemClickListener { _, _, position, _ ->
            showDetails(movies.results[position].id)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return true
    }

    private fun showDetails(id: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(IntentConstants.DETAILS_INTENT_KEY, id)
        startActivity(intent)
    }

}