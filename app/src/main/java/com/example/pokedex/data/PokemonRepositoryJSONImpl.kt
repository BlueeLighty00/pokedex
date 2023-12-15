package com.example.pokedex.data

import android.content.Context
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.utils.PokemonDeserializer
import com.google.gson.GsonBuilder
import java.io.InputStreamReader

class PokemonRepositoryJSONImpl: IPokemonRepositoryJSON {
    override fun getPokemon(context: Context): Pokemon {
        val json = InputStreamReader(context.assets.open("ditto.json"))
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(Pokemon::class.java, PokemonDeserializer())
        val gson = gsonBuilder.create()

        return gson.fromJson(json, Pokemon::class.java)
    }
}