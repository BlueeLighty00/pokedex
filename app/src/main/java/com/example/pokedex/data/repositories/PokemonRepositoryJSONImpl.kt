package com.example.pokedex.data.repositories

import android.app.Application
import com.example.pokedex.data.utils.deserializer.PokemonDeserializer
import com.example.pokedex.data.utils.deserializer.PokemonListDeserializer
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.IPokemonRepository
import com.google.gson.GsonBuilder
import java.io.InputStreamReader
import javax.inject.Inject

class PokemonRepositoryJSONImpl @Inject constructor(application: Application): IPokemonRepository {

    private val context = application.applicationContext

    override suspend fun getPokemon(name: String): Pokemon {
        val json = InputStreamReader(context.assets.open("$name.json"))
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(Pokemon::class.java, PokemonDeserializer())
        val gson = gsonBuilder.create()

        return gson.fromJson(json, Pokemon::class.java)
    }

    override suspend fun getPokemonList(limit: Int): PokemonList {
        val json = InputStreamReader(context.assets.open("list.json"))
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(PokemonList::class.java, PokemonListDeserializer())
        val gson = gsonBuilder.create()

        return  gson.fromJson(json, PokemonList::class.java)
    }

}