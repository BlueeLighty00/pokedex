package com.example.pokedex.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex.domain.models.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeTopBar(pokemon: Pokemon, navController: NavHostController) {
    TopAppBar(
        title = { Text(text = "Pokedex", color = Color.White) },
        colors = TopAppBarDefaults.largeTopAppBarColors(pokemon.primaryType.color),
        navigationIcon = {
            IconButton(onClick = { navController.navigate("PokemonList") }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        },
        actions = {
            Text(
                text = "#${"%04d".format(pokemon.id)}",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    )
}