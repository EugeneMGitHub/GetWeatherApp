package com.example.weatherapptesttask.domain

import android.app.Application

import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AppInstance : Application() {}