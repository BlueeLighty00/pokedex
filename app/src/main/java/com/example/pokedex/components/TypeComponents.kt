package com.example.pokedex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.Types

@Composable
fun PokemonTyping(pokemon: Pokemon) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp), horizontalArrangement = Arrangement.Center) {
        RowType(type = pokemon.primaryType)
        if(pokemon.secondaryType != null) {
            Spacer(modifier = Modifier.width(20.dp))
            RowType(type = pokemon.secondaryType)
        }
    }
}

@Composable
fun RowType(type: Types) {
    Row(modifier = Modifier
        .background(
            color = type.color,
            shape = RoundedCornerShape(
                bottomEnd = 40.dp,
                bottomStart = 40.dp,
                topEnd = 40.dp,
                topStart = 40.dp
            )
        )
        .width(130.dp)
        .height(30.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Text(type.name)
    }
}