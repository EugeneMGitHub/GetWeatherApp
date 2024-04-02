package com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapptesttask.R
import com.example.weatherapptesttask.presentation.ui.theme.LightIcon
import com.example.weatherapptesttask.presentation.ui.theme.LightText
import com.example.weatherapptesttask.presentation.ui.theme.Poppins
import com.example.weatherapptesttask.presentation.ui.theme.WeatherAppTestTaskTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SimpleDateFormat")
@Composable
fun ForecastCardUI(
    temperature: String,
    date: String,
    condition: String,
    pictureUrl: String,
    humidity: String,
    wind: String
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        val dateParsed = LocalDate.parse(date)
        val formatter = DateTimeFormatter.ofPattern("dd MMMM", Locale("ru"))
        val formattedDate = dateParsed.format(formatter)

        Box(
            Modifier
                .width(150.dp)
                .height(180.dp)
                .padding(10.dp),

            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    formattedDate,
                    fontSize = 15.sp
                )

                AsyncImage(
                    model = "https:$pictureUrl",
                    contentDescription = "This is an example image",
                    modifier = Modifier
                        .size(35.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = condition,
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    color = LightText,
                    lineHeight = 15.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "$temperature°C",
                    fontFamily = Poppins,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray

                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_weather2),
//                        contentDescription = "",
//                        Modifier.size(12.dp),
//                        tint = LightIcon
//                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = humidity,
                        fontFamily = Poppins,
                        fontSize = 10.sp,
                        color = LightText
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_wind),
                        contentDescription = "",
                        Modifier.size(12.dp),
                        tint = LightIcon
                    )
                    Text(
                        text = wind,
                        fontFamily = Poppins,
                        fontSize = 10.sp,
                        color = LightText
                    )
                }
            }

        }


    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ForecastCardUIPreview() {
    WeatherAppTestTaskTheme {
        ForecastCardUI(
            "30",
            "01 апреля",
            "Переменная облачность",
            "//cdn.weatherapi.com/weather/64x64/day/116.png",
            "23",
            "100"
        )
    }
}