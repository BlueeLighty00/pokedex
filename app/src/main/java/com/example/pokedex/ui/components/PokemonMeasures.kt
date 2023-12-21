package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.domain.models.Pokemon

@Composable
fun PokeMeasures(pokemon: Pokemon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp), horizontalArrangement = Arrangement.Center
    ) {
        RowMeasures(pokemon)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp), horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .width(130.dp)
                .height(30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Weight", color = Color.White, fontSize = 16.sp)
        }
        Row(
            modifier = Modifier
                .width(130.dp)
                .height(30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Height", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
private fun RowMeasures(pokemon: Pokemon) {
    Row(
        modifier = Modifier
            .width(130.dp)
            .height(30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text("${pokemon.weight} KG", color = Color.White, fontSize = 23.sp)
    }
    Row(
        modifier = Modifier
            .width(130.dp)
            .height(30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text("${pokemon.height} M", color = Color.White, fontSize = 23.sp)
    }
}