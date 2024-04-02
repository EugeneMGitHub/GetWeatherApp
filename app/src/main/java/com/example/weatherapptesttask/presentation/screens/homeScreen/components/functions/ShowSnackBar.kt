package com.example.weatherapptesttask.presentation.screens.homeScreen.components.functions

import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun showSnackBar(
    snackbarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope,
    onButtonClick: () -> Unit = {}
) {
    coroutineScope.launch {
        val snackBarResult = snackbarHostState.showSnackbar(
            message = "Нужно включить разрешение на определение геолокации.",
            actionLabel = "Хорошо",
            duration = androidx.compose.material3.SnackbarDuration.Short
        )

        when (snackBarResult) {
            androidx.compose.material3.SnackbarResult.ActionPerformed -> {onButtonClick()} // actions when action label wasnclicked on
            androidx.compose.material3.SnackbarResult.Dismissed -> {} // actions when action label wasn't actually clicked on

        }
    }

}