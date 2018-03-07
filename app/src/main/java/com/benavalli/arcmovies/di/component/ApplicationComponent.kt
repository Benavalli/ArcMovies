package com.benavalli.arcmovies.di.component

import android.content.Context
import com.benavalli.arcmovies.api.repository.HomeRepository
import com.benavalli.arcmovies.di.module.ApplicationModule
import com.benavalli.arcmovies.di.module.HomeRepositoryModule
import com.benavalli.arcmovies.di.module.ServiceModule
import com.benavalli.arcmovies.di.scope.ApplicationScope
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ServiceModule::class, HomeRepositoryModule::class])
interface ApplicationComponent {
  val applicationContext: Context
  val homeRepository: HomeRepository
}