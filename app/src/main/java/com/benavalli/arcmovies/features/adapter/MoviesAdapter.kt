package com.benavalli.arcmovies.features.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.benavalli.arcmovies.BuildConfig
import com.benavalli.arcmovies.R
import com.benavalli.arcmovies.api.config.BuildConstants
import com.benavalli.arcmovies.databinding.ListMoviesBinding
import com.benavalli.arcmovies.domain.UpcomingMovies.UpcomingMovie
import com.squareup.picasso.Picasso

class MoviesAdapter : ArrayAdapter<UpcomingMovie> {

    private var movies = ArrayList<UpcomingMovie>()
    private var adapterContext: Context? = null

    constructor(context: Context, movies: ArrayList<UpcomingMovie>): super(context, 0, movies) {
        this.movies = movies
        this.adapterContext = context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val inflater = LayoutInflater.from(context)
        val binding : ListMoviesBinding = DataBindingUtil
                .inflate(inflater, R.layout.list_movies, null, false)

        binding.listMovieTitle.text = movies[position].name
        binding.listMovieGenresValue.text = movies[position].genre.map{ it }.joinToString(", ")
        binding.listMovieReleaseValue.text = movies[position].releaseDate
        Picasso.with(context).load(BuildConstants.BASE_IMAGE_URL + movies[position].imagePath)
                .into(binding.listMovieFolder);

        return binding.root
    }

    override fun getCount() = movies.size

    override fun getItem(position: Int) = movies[position]

}
