package com.example.pokedex.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.pokedex.data.model.PokemonList
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.theme.Purple40
import com.example.pokedex.viewmodel.PokemonViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun PokeList(
    list: PokemonList,
    navController: NavHostController,
    pokemonViewModel: PokemonViewModel
) {
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(3)) {
        items(list.pokemonList){
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(colorScheme.background)
                .clickable {
                    pokemonViewModel.setPokemon(it)
                    navController.navigate("PokemonData")
                }){
                Spacer(modifier = Modifier.height(30.dp))
                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .height(75.dp)
                        .padding(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Purple40
                    )
                ) {
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                        Text(
                            it.replaceFirstChar { it.uppercase() },
                            color = Color.White,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}