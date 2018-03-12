package com.benavalli.arcmovies.di.module

import com.benavalli.arcmovies.api.Endpoints
import com.benavalli.arcmovies.api.repository.HomeRepository
import com.benavalli.arcmovies.api.repository.HomeRepositoryImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeRepositoryModule {

    @Singleton
    @Provides
    fun providesHomeRepository(endpoints: Endpoints) : HomeRepository = HomeRepositoryImp(endpoints)
}
