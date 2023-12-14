package com.example.pokedex.data.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class PokemonListDeserializer : JsonDeserializer<PokemonList> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): PokemonList {
        val jsonObject = json.asJsonObject
        val pokemonList = ArrayList<String>()
        for (pokemon in jsonObject.get("results").asJsonArray) {
            pokemonList.add(pokemon.asJsonObject.get("name").asString)
        }
        return PokemonList(
            pokemonList = pokemonList
        )
    }
}