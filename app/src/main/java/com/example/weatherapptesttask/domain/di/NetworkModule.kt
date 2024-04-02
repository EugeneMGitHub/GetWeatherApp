package com.example.weatherapptesttask.domain.di

import com.example.weatherapptesttask.data.common.constants.Constants.BASE_URL
import com.example.weatherapptesttask.data.remote.api.RetrofitWeatherApi

import com.example.weatherapptesttask.data.remote.dataSources.WeatherRemoteDataSource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        val okHttpClient = OkHttpClient()
            .newBuilder()
            .retryOnConnectionFailure(true)
            .callTimeout(3, TimeUnit.SECONDS)
            .build()

        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit): RetrofitWeatherApi {
        return retrofit.create(RetrofitWeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRemoteDataSource(retrofitWeatherApi: RetrofitWeatherApi) : WeatherRemoteDataSource {
        return WeatherRemoteDataSource(retrofitWeatherApi = retrofitWeatherApi)
    }

}