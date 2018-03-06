package com.benavalli.arcmovies.di.module

import com.benavalli.arcmovies.api.Endpoints
import com.benavalli.arcmovies.api.config.BuildConstants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ServiceModule {

    private fun getClient() : OkHttpClient.Builder {
        val httpClient = OkHttpClient().newBuilder()
        val interceptor = Interceptor { chain ->
            var request = chain.request()
            val url = request.url().newBuilder()
                        .addQueryParameter("api_key", BuildConstants.API_KEY)
                        .addQueryParameter("language", BuildConstants.API_LANG)
                        .build()
            request = request.newBuilder().url(url).build()
            chain?.proceed(request)
        }
        httpClient.networkInterceptors().add(interceptor)
        return httpClient
    }

    @Provides
    @Singleton
    fun providesAppApi(gson: Gson): Endpoints {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConstants.BASE_API_URL)
                .client(getClient().build())
                .build()

        return retrofit.create(Endpoints::class.java)
    }
}