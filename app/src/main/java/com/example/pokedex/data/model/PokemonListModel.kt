package com.example.pokedex.data.model

import com.google.gson.GsonBuilder

fun getPokemonListFromApi(json: String): PokemonList {
    val gsonBuilder = GsonBuilder()
    gsonBuilder.registerTypeAdapter(PokemonList::class.java, PokemonListDeserializer())
    val gson = gsonBuilder.create()

    return gson.fromJson(json, PokemonList::class.java)
}