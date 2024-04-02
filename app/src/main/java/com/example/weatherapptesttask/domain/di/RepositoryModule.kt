package com.example.weatherapptesttask.domain.di

import com.example.weatherapptesttask.data.remote.api.RetrofitWeatherApi
import com.example.weatherapptesttask.data.remote.dataSources.WeatherRemoteDataSource
import com.example.weatherapptesttask.data.remote.repositories.WeatherRepository
import com.example.weatherapptesttask.data.remote.repositories.WeatherRepositoryImpl


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(
        weatherRemoteDataSource: WeatherRemoteDataSource
    ): WeatherRepository {
        return WeatherRepositoryImpl(weatherRemoteDataSource)
    }
}
