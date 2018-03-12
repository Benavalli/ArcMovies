package com.benavalli.arcmovies.di.component

import com.benavalli.arcmovies.di.scope.ActivityScope
import com.benavalli.arcmovies.features.home.contract.HomeActivityContract
import com.benavalli.arcmovies.features.home.presenter.HomeActivityPresenter
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface HomeActivityComponent : HomeActivityContract.Component<HomeActivityContract.View, HomeActivityPresenter> {
    override fun presenter(): HomeActivityPresenter
}