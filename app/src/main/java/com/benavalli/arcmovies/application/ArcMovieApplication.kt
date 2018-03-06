package com.benavalli.arcmovies.application

import android.app.Application
import com.benavalli.arcmovies.di.component.ApplicationComponent
import com.benavalli.arcmovies.di.module.ApplicationModule
import com.benavalli.arcmovies.di.component.DaggerApplicationComponent

internal class ArcMovieApplication : Application() {

  companion object {
    @JvmStatic lateinit var component: ApplicationComponent
  }

  override fun onCreate() {
    super.onCreate()
    buildComponent()
  }

  private fun buildComponent() {
    component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
  }
}