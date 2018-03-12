package com.benavalli.arcmovies.features.home.contract

import com.benavalli.arcmovies.base.BaseContract
import com.benavalli.arcmovies.domain.UpcomingMovies

interface HomeActivityContract {

    interface View : BaseContract.View {
        fun bindMovies(movies : UpcomingMovies)
        fun bindSearch(movies : UpcomingMovies)
        fun emptySearch()
    }

    interface Presenter<V : View> : BaseContract.Presenter<V> {
        fun loadMovies()
        fun loadGenreList()
        fun searchMovies(query: String)
    }

    interface Component<V : View ,P : Presenter<V>> : BaseContract.Component<V,P>

}