package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.screens.PokeListScreen
import com.example.pokedex.ui.screens.PokemonScreen
import com.example.pokedex.ui.screens.WelcomeScreen
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.ui.viewmodels.PokemonListViewModel
import com.example.pokedex.ui.viewmodels.PokemonViewModel
import com.example.pokedex.ui.viewmodels.SearchBarViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val pokemonViewModel: PokemonViewModel by viewModels()
                val pokemonListViewModel: PokemonListViewModel by viewModels()
                val navController = rememberNavController()
                val searchBarViewModel = SearchBarViewModel()

                Surface(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                ) {
                    NavHost(navController = navController, startDestination = "WelcomeScreen")
                    {
                        composable("PokemonData") { PokemonScreen(pokemonViewModel, navController) }
                        composable("PokemonList") {
                            PokeListScreen(
                                list = pokemonListViewModel,
                                navController = navController,
                                pokemonViewModel,
                                searchBarViewModel
                            )
                        }
                        composable("WelcomeScreen") { WelcomeScreen(navController = navController) }
                    }
                }
            }
        }
    }
}
