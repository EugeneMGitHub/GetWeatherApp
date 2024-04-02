package com.example.weatherapptesttask.domain.useCases

import com.example.weatherapptesttask.data.common.classes.UploadStatus

import com.example.weatherapptesttask.data.remote.repositories.WeatherRepository
import com.example.weatherapptesttask.data.remote.models.WeatherDataModel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    operator fun invoke(city: String) : Flow<UploadStatus<WeatherDataModel>> = flow{

        try {
            emit(UploadStatus.Loading<WeatherDataModel>())
            val weatherData = weatherRepository.getWeatherData(city=city)
            emit(UploadStatus.Success<WeatherDataModel>(weatherData))
        } catch (e: retrofit2.HttpException){
            val message = if (e.localizedMessage != null) "Произошла ошибка ${e.localizedMessage}. \n Проверьте интернет-соединение и повторите попытку." else "Произошла неожиданная ошибка. Проверьте интернет-соединение и повторите попытку."
            emit(UploadStatus.Error<WeatherDataModel>(message =message))
        }catch (e : IOException){
            emit(UploadStatus.Error<WeatherDataModel>(message = "Проверьте подключение к Интернету и повторите попытку."))
        }
            }
}