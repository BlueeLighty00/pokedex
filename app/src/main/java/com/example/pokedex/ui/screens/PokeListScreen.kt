package com.example.pokedex.ui.screens

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.pokedex.R
import com.example.pokedex.ui.components.RowListPokemon
import com.example.pokedex.ui.components.SearchBar
import com.example.pokedex.ui.viewmodels.PokemonListViewModel
import com.example.pokedex.ui.viewmodels.PokemonViewModel
import com.example.pokedex.ui.viewmodels.SearchBarViewModel

@Composable
fun PokeListScreen(
    list: PokemonListViewModel,
    navController: NavHostController,
    pokemonViewModel: PokemonViewModel,
    searchBarViewModel: SearchBarViewModel
) {
    val mMediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.whosthatpokemon)

    Column(modifier = Modifier.fillMaxSize()) {

        SearchBar(searchBarViewModel = searchBarViewModel, pokemonListViewModel = list)

        val pokeList = list.pokemonListFiltered.observeAsState()

        if (pokeList.value != null) {
            LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(1)) {
                items(pokeList.value!!) { namePokemon ->
                    RowListPokemon(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorScheme.background)
                            .clickable {
                                pokemonViewModel.loadPokemon(namePokemon)
                                navController.navigate("PokemonData")
                                mMediaPlayer.start()
                            },
                        namePokemon = namePokemon
                    )
                }
            }
        }
    }
}