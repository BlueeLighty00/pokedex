package com.example.pokedex.domain.usecases

import com.example.pokedex.data.repositories.PokemonRepositoryJSONImpl
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.IPokemonRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: IPokemonRepository
) {

    suspend fun getList(limit: Int): PokemonList {
        return repository.getPokemonList(limit)
    }

}