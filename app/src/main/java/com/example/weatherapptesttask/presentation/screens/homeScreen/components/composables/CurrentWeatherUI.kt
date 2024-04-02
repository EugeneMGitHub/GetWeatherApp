package com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapptesttask.data.remote.models.CurrentModel
import com.example.weatherapptesttask.presentation.ui.theme.DarkGrey
import com.example.weatherapptesttask.presentation.ui.theme.LightText
import com.example.weatherapptesttask.presentation.ui.theme.Poppins

@Composable
fun CurrentWeatherUI(currentWeatherData: CurrentModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
    ) {
        Card(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(0.dp)
        ) {

            Row(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Температура",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "${currentWeatherData.temp_c} °C",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                    Text(
                        text = "Влажность",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "${currentWeatherData.humidity} %",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                }

                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .height(80.dp)
                        .background(LightText)
                )
                Column {
                    Text(
                        text = "Ветер",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "${currentWeatherData.wind_kph} км/ч",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                    Text(
                        text = "Давление",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "${currentWeatherData.pressure_mb} гПа",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                }

            }
        }
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {

            AsyncImage(
                model = "https:${currentWeatherData.condition.icon}",
                contentDescription = "This is an example image",
                modifier = Modifier
                    .size(140.dp)
                    .padding(top = 10.dp)
                    .align(Alignment.TopCenter)
            )

        }
    }
}