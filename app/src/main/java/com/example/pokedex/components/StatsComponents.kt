package com.example.pokedex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.Stats

const val MAX_STAT = 255
@Composable
fun StatBar(stat: Stats, quant: Int?) {
    Row(modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "${stat.stat}: $quant/$MAX_STAT", color = Color.White)
        Row(modifier = Modifier
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp, topEnd = 40.dp, topStart = 40.dp)
            )
            .width(MAX_STAT.dp).height(20.dp)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End, modifier = Modifier
                .background(
                    color = stat.color,
                    shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp, topEnd = 40.dp, topStart = 40.dp)
                )
                .width(quant!!.dp).height(20.dp)
                .padding(end = 10.dp)){}
        }
    }
}

@Composable
fun PokeStats(pokemon: Pokemon) {
    Text("Base Stats", color = Color.White, fontSize = 20.sp)
    for(stat in Stats.values()){
        Spacer(modifier = Modifier.height(10.dp))
        StatBar(stat, pokemon.stats[stat.name])
    }
}