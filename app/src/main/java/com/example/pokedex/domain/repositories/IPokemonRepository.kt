package com.example.pokedex.domain.repositories

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList

interface IPokemonRepository {
    suspend fun getPokemon(name: String): Pokemon

    suspend fun getPokemonList(limit: Int): PokemonList
}