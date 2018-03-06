package com.benavalli.arcmovies.di.component

import android.content.Context
import com.benavalli.arcmovies.di.module.ApplicationModule
import com.benavalli.arcmovies.di.module.ServiceModule
import com.benavalli.arcmovies.di.scope.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class, ServiceModule::class])
interface ApplicationComponent {
  val applicationContext: Context
}