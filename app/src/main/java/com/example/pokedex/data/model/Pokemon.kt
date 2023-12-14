package com.example.pokedex.data.model

data class Pokemon(
    val id: Int,
    val sprite: String,
    val spriteShiny: String,
    val name: String,
    val ability: String,
    val primaryType: Types,
    val secondaryType: Types?,
    val weight: Float,
    val height: Float,
    val stats: Map<String, Int>
)