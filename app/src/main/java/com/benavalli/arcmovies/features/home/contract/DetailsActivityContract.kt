package com.benavalli.arcmovies.features.home.contract

import com.benavalli.arcmovies.base.BaseContract
import com.benavalli.arcmovies.domain.MovieDetails

interface DetailsActivityContract {

    interface View : BaseContract.View {
        fun bindDetails(details: MovieDetails)
    }

    interface Presenter<V : View> : BaseContract.Presenter<V> {
        fun loadDetails(id: Int)
    }

    interface Component<V : View ,P : Presenter<V>> : BaseContract.Component<V,P>
}