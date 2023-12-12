package com.example.pokedex.data.model

import android.content.Context

import com.google.gson.GsonBuilder
import java.io.InputStreamReader



fun getPokemonFromApi(json: String): Pokemon {
    val gsonBuilder = GsonBuilder()
    gsonBuilder.registerTypeAdapter(Pokemon::class.java, PokemonDeserializer())
    val gson = gsonBuilder.create()

    return gson.fromJson(json, Pokemon::class.java)
}

fun getPokemonFromJson(context: Context): Pokemon {
    val json = InputStreamReader(context.assets.open("ditto.json"))
    val gsonBuilder = GsonBuilder()
    gsonBuilder.registerTypeAdapter(Pokemon::class.java, PokemonDeserializer())
    val gson = gsonBuilder.create()

    return gson.fromJson(json, Pokemon::class.java)

}

