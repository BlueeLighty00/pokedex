package com.example.pokedex.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.model.Pokemon

@Composable
fun PokemonNameAbility(pokemon: Pokemon) {
    Text(pokemon.name, color = Color.White, fontSize = 30.sp)
    Text(text = "Ability: ${pokemon.ability}", color = Color.White, fontSize = 20.sp)
}