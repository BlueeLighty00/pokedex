package com.example.pokedex.domain.usecases

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.IPokemonRepository
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val repository: IPokemonRepository
) {

    suspend fun getPokemonInfo(name: String): Pokemon {
        return repository.getPokemon(name)
    }

}