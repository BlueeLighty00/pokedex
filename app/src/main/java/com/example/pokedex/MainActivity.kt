package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.viewmodel.PokemonViewModel
import com.example.pokedex.components.Dex
import com.example.pokedex.components.PokeList
import com.example.pokedex.viewmodel.PokemonListViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val pokemonViewModel: PokemonViewModel by viewModels()
                val pokemonListViewModel = PokemonListViewModel()

                val pokemon by pokemonViewModel.pokemon.observeAsState()
                val pokemonList by pokemonListViewModel.pokemonList.observeAsState()
                val navController = rememberNavController()



                Surface(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                ) {
                    if(pokemon != null && pokemonList != null) {
                        NavHost(navController = navController, startDestination = "PokemonList")
                        {
                            composable("PokemonData") { Dex(pokemon!!, navController) }
                            composable("PokemonList") { PokeList(list = pokemonList!!, navController = navController, pokemonViewModel, lifecycleScope) }
                        }
                    }
                }
            }
        }
    }
}
