package com.example.weatherapptesttask.data.remote.models


data class WeatherDataModel(
    val location: LocalModel,
    val current: CurrentModel,
    val forecast: ForecastModel
)

data class LocalModel(
    val name: String,
    val localtime: String
)

data class CurrentModel(
    val last_updated: String ="",
    val temp_c: Float = 0f,
    val condition: ConditionModel,
    val  wind_kph:Float =0f,
    val humidity: Int = 0,
    val pressure_mb:Int = 0,
)



data class ConditionModel(
    val text: String = "",
    val icon: String = ""
)

data class ForecastModel(
    val forecastday: List<ForecastDayModel>
)

data class ForecastDayModel(
    val date: String,
    val day: DayModel,
)

data class DayModel(
    val avgtemp_c: String,
    val maxwind_kph: Float,
    val avghumidity: Float,
    val condition: ConditionModel
)

data class HourModel(
    val time: String,
    val temp_c: Float,
    val condition: ConditionModel
)
