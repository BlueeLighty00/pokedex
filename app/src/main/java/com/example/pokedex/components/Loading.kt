package com.example.pokedex.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun loading() {
    CircularProgressIndicator( modifier = Modifier.height(50.dp).width(100.dp) )
}