package com.example.weatherapptesttask.presentation.screens.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapptesttask.R
import com.example.weatherapptesttask.presentation.ui.theme.LightText
import com.example.weatherapptesttask.presentation.ui.theme.Poppins
import com.example.weatherapptesttask.presentation.ui.theme.Primary
import com.example.weatherapptesttask.presentation.ui.theme.ReemKufi
import com.example.weatherapptesttask.presentation.ui.theme.WeatherAppTestTaskTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigationAction: () -> Unit = {}
) {

    LaunchedEffect(key1 = Unit,) {
        delay(1500L)
        navigationAction()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val annotatedString = AnnotatedString.Builder("WeatherApp")
            .apply {
                addStyle(
                    SpanStyle(
                        color = Primary,
                        fontSize = 40.sp
                    ), 0, 7
                )
            }
        Image(
            painter = painterResource(id = R.drawable.ic_weather1),
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = annotatedString.toAnnotatedString(),
            fontFamily = Poppins,
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkGray,
            modifier = Modifier,
            textAlign = TextAlign.Center
        )
    }
}



@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    WeatherAppTestTaskTheme {
        SplashScreen()
    }
}

