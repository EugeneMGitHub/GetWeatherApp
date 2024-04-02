package com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapptesttask.presentation.screens.homeScreen.HomeScreenViewModel
import com.example.weatherapptesttask.presentation.screens.homeScreen.WeatherInfoState

@Composable
fun ErrorComposable(
    homeScreenViewModel: HomeScreenViewModel,
    weatherDataState: WeatherInfoState,
    changeCityClickVM: Boolean,
    lastShownCity: String
) {
    if(weatherDataState.error.isNotBlank()){

        if (changeCityClickVM==false){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = weatherDataState.error,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(50.dp))
                OutlinedButton(onClick = {
                    homeScreenViewModel.changeWeatherDataStateToDefault()
                    homeScreenViewModel.getWeather(city = lastShownCity)
                }) {
                    Text(
                        text = "Повторить попытку",
                        modifier = Modifier
                    )
                }
            }
        }else{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = "Вы не правильно ввели город. Попробуйте еще раз.",
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)

                )
                Spacer(modifier = Modifier.height(50.dp))
                OutlinedButton(onClick = {
                    homeScreenViewModel.changeWeatherDataStateToDefault()
                    homeScreenViewModel.getWeather(city = lastShownCity)
                }) {
                    Text(
                        text = "Повторить попытку",
                        modifier = Modifier
                    )
                }
            }
        }



    }

}