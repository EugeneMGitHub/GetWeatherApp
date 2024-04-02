package com.example.weatherapptesttask.presentation.screens.homeScreen.components.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(
    modifier: Modifier,
    onRefreshClick: () -> Unit = {},
    onGetCurentLocationClick : () -> Unit = {},
) {
    
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        IconButton(
            onClick = { onGetCurentLocationClick() }) {
            Icon(Icons.Filled.LocationOn, "Current location", tint = Color.DarkGray, modifier = Modifier.size(30.dp))
        }

        IconButton(
            onClick = { onRefreshClick() }) {
            Icon(Icons.Filled.Refresh, "Refresh", tint = Color.DarkGray, modifier = Modifier.size(30.dp))
        }

        
    }
}