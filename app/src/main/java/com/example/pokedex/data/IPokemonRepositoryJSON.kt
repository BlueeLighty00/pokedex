package com.example.pokedex.data

import android.content.Context
import com.example.pokedex.data.model.Pokemon

interface IPokemonRepositoryJSON {
    fun getPokemon(context: Context) : Pokemon
}