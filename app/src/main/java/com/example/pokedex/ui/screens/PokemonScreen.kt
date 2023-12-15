package com.example.pokedex.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.ui.components.PokeImage
import com.example.pokedex.ui.components.PokeMeasures
import com.example.pokedex.ui.components.PokeStats
import com.example.pokedex.ui.components.PokeTopBar
import com.example.pokedex.ui.components.PokemonNameAbility
import com.example.pokedex.ui.components.PokemonTypes
import com.example.pokedex.ui.viewmodels.PokemonViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(pokemonViewModel: PokemonViewModel, navController: NavHostController) {

    val pokemon: Pokemon? by pokemonViewModel.pokemon.observeAsState()

    if(pokemon == null) {

    }else {
        val systemUiController = rememberSystemUiController()
        systemUiController.setStatusBarColor(pokemon!!.primaryType.color)

        Scaffold(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            topBar = { PokeTopBar(pokemon!!, navController) }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                PokeImage(pokemon = pokemon!!)

                Spacer(modifier = Modifier.height(25.dp))

                PokemonNameAbility(pokemon!!)

                Spacer(modifier = Modifier.height(20.dp))

                PokemonTypes(pokemon!!)

                Spacer(modifier = Modifier.height(10.dp))

                PokeMeasures(pokemon!!)

                Spacer(modifier = Modifier.height(10.dp))

                PokeStats(pokemon!!)
            }
        }
    }
}