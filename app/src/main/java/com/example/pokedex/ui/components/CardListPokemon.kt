package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.theme.Purple40

@Composable
fun RowListPokemon(modifier: Modifier, namePokemon: String) {
    Row(modifier = modifier) {
        Spacer(modifier = Modifier.height(30.dp))
        CardListPokemon(namePokemon)
    }
}

@Composable
fun CardListPokemon(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(40.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Purple40
        )
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                name.replaceFirstChar { it.uppercase() },
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }
    }
}