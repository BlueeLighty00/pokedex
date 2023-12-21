package com.example.pokedex.data

import android.app.Application
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.PokemonList
import com.example.pokedex.data.utils.PokemonDeserializer
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
        TODO("Not yet implemented")
    }

}