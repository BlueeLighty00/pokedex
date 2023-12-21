package com.example.pokedex.data.repositories

import com.example.pokedex.data.sources.remote.api.RetrofitInstance
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.data.utils.deserializer.PokemonDeserializer
import com.example.pokedex.data.utils.deserializer.PokemonListDeserializer
import com.example.pokedex.domain.repositories.IPokemonRepository
import com.google.gson.GsonBuilder
import javax.inject.Inject


class PokemonAPIRepositoryImpl @Inject constructor(): IPokemonRepository {
    override suspend fun getPokemon(name: String): Pokemon {
        val json = RetrofitInstance.api.getPokemonData(name)
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(Pokemon::class.java, PokemonDeserializer())
        val gson = gsonBuilder.create()

        return gson.fromJson(json, Pokemon::class.java)
    }

    override suspend fun getPokemonList(limit: Int): PokemonList {
        val json = RetrofitInstance.api.getListPokemon(limit)
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(PokemonList::class.java, PokemonListDeserializer())
        val gson = gsonBuilder.create()

        return gson.fromJson(json, PokemonList::class.java)
    }
}