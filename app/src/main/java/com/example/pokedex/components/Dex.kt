package com.example.pokedex.components

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.pokedex.data.model.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dex(pokemon: Pokemon, navController: NavHostController) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(pokemon.primaryType.color)

    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        topBar = { PokeTopBar(pokemon, navController) }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {

            PokeImage(pokemon = pokemon)

            Spacer(modifier = Modifier.height(25.dp))

            PokemonNameAbility(pokemon)

            Spacer(modifier = Modifier.height(20.dp))

            PokemonTyping(pokemon)

            Spacer(modifier = Modifier.height(10.dp))

            PokeMeasures(pokemon)

            Spacer(modifier = Modifier.height(10.dp))

            PokeStats(pokemon)
        }
    }
}



@Composable
private fun PokemonNameAbility(pokemon: Pokemon) {
    Text(pokemon.name, color = Color.White, fontSize = 30.sp)
    Text(text = "Ability: ${pokemon.ability}", color = Color.White, fontSize = 20.sp)
}