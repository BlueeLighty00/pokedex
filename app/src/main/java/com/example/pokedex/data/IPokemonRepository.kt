package com.example.pokedex.data

import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.PokemonList

interface IPokemonRepository {
    suspend fun getPokemon(name: String): Pokemon

    suspend fun getPokemonList(limit: Int): PokemonList
}