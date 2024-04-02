package com.example.weatherapptesttask.data.common.functions

import android.Manifest
import android.app.Activity
import androidx.core.app.ActivityCompat

fun Activity.askLocationPermission() {
    ActivityCompat.requestPermissions(
        this,
        arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ),
        0
    )
}

