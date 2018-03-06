package com.benavalli.arcmovies.di.module

import android.app.Application
import android.content.Context
import com.benavalli.arcmovies.di.scope.ApplicationScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

  @ApplicationScope
  @Provides
  fun provideApplicationContext(): Context {
    return application
  }

  @Provides
  @Singleton
  fun provideGson(): Gson = GsonBuilder().serializeNulls().create()
}