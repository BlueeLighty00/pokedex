package com.example.pokedex.ui.screens

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.R
import com.example.pokedex.data.model.PokemonList
import com.example.pokedex.ui.components.CardListPokemon
import com.example.pokedex.ui.viewmodels.PokemonViewModel

@Composable
fun PokeListScreen(
    list: PokemonList,
    navController: NavHostController,
    pokemonViewModel: PokemonViewModel
) {
    val mMediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.whosthatpokemon)
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(3)) {
        items(list.pokemonList) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(colorScheme.background)
                .clickable {
                    pokemonViewModel.loadPokemon(it)
                    navController.navigate("PokemonData")
                    mMediaPlayer.start()
                }) {
                Spacer(modifier = Modifier.height(30.dp))
                CardListPokemon(it)
            }
        }
    }
}