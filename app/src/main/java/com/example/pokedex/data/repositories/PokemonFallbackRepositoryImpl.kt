package com.example.pokedex.data.repositories

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.IPokemonRepository
import javax.inject.Inject

class PokemonFallbackRepositoryImpl @Inject constructor(
    private val pokemonRepositoryJSONImpl: PokemonRepositoryJSONImpl,
    private val pokemonAPIRepositoryImpl: PokemonAPIRepositoryImpl
): IPokemonRepository {
    override suspend fun getPokemon(name: String): Pokemon {
        return try {
            pokemonAPIRepositoryImpl.getPokemon(name)
        }catch (e: Exception) {
            return pokemonRepositoryJSONImpl.getPokemon("ditto")
        }
    }

    override suspend fun getPokemonList(limit: Int): PokemonList {
        return try {
            pokemonAPIRepositoryImpl.getPokemonList(limit)
        }catch (e: Exception) {
            pokemonRepositoryJSONImpl.getPokemonList(limit)
        }
    }


}