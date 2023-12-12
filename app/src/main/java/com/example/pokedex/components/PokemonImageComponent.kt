package com.example.pokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.pokedex.R
import com.example.pokedex.data.model.Pokemon

@Composable
fun PokeImage(pokemon: Pokemon) {
    var shiny by remember{mutableStateOf(true)}
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = pokemon.primaryType.image), contentDescription = null, modifier = Modifier
            .matchParentSize()
            .clip(shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)), contentScale = ContentScale.Crop)
        SubcomposeAsyncImage(
            model = if (shiny) pokemon.sprite else pokemon.spriteShiny,
            loading = { Image(painter = painterResource(id = R.drawable.dittoimage), contentDescription = "") },
            contentDescription = "",
            modifier = Modifier
                .padding(15.dp)
                .size(width = 300.dp, height = 250.dp))

        Button(onClick = {shiny = !shiny}, modifier = Modifier.align(Alignment.TopStart), colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)){
            Text("Shiny", color = Color.White)
        }
    }
}