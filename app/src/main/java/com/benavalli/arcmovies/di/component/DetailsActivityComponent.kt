package com.benavalli.arcmovies.di.component

import com.benavalli.arcmovies.di.scope.ActivityScope
import com.benavalli.arcmovies.features.home.contract.DetailsActivityContract
import com.benavalli.arcmovies.features.home.presenter.DetailsActivityPresenter
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface DetailsActivityComponent : DetailsActivityContract.Component<DetailsActivityContract.View, DetailsActivityPresenter> {
    override fun presenter(): DetailsActivityPresenter
}