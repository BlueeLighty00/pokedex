package com.example.pokedex.data

import com.example.pokedex.data.api.RetrofitInstance
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.utils.PokemonDeserializer
import com.example.pokedex.data.model.PokemonList
import com.example.pokedex.data.utils.PokemonListDeserializer
import com.google.gson.GsonBuilder

class PokemonAPIRepositoryImpl: IPokemonRepository {
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