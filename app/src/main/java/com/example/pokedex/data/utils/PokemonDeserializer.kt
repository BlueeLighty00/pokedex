package com.example.pokedex.data.utils

import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.Types
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class PokemonDeserializer : JsonDeserializer<Pokemon> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Pokemon {
        val jsonObject = json.asJsonObject

        return Pokemon(
            id = getIdFromJson(jsonObject),
            sprite = getSpriteFromJson(jsonObject),
            spriteShiny = getShinySpriteFromJson(jsonObject),
            name = getNameFromJson(jsonObject),
            ability = getAbilityFromJson(jsonObject),
            primaryType = getPrimaryTypeFromJson(jsonObject),
            secondaryType = getSecondaryTypeFromJson(jsonObject),
            weight = getWeightFromJson(jsonObject) / 10,
            height = getHeightFromJson(jsonObject) / 10,
            stats = getStatsFromJson(jsonObject)
        )
    }


    private fun getShinySpriteFromJson(jsonObject: JsonObject): String {
        val officialArtwork =
            jsonObject.get("sprites").asJsonObject.get("other").asJsonObject.get("official-artwork").asJsonObject.get(
                "front_shiny"
            )
        if (!officialArtwork.isJsonNull) {
            return officialArtwork.asString
        }

        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/shiny/132.png"

    }

    private fun getSpriteFromJson(jsonObject: JsonObject): String {
        val officialArtwork =
            jsonObject.get("sprites").asJsonObject.get("other").asJsonObject.get("official-artwork").asJsonObject.get(
                "front_default"
            )
        if (!officialArtwork.isJsonNull) {
            return officialArtwork.asString
        }

        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/132.png"
    }

    private fun getStatsFromJson(jsonObject: JsonObject): Map<String, Int> {
        val stats: MutableMap<String, Int> = mutableMapOf()

        for (stat in jsonObject.get("stats").asJsonArray) {
            val name = stat.asJsonObject.get("stat").asJsonObject.get("name").asString
            val value = stat.asJsonObject.get("base_stat").asInt
            stats.put(name, value)
        }

        return mapOf(
            Pair("HP", stats.getValue("hp")),
            Pair("ATK", stats.getValue("attack")),
            Pair("DEF", stats.getValue("defense")),
            Pair("SPATK", stats.getValue("special-attack")),
            Pair("SPDEF", stats.getValue("special-defense")),
            Pair("SPD", stats.getValue("speed"))
        )
    }

    private fun getSecondaryTypeFromJson(jsonObject: JsonObject): Types? {
        var secondaryType: Types? = null
        if (jsonObject.get("types").asJsonArray.size() > 1) {
            secondaryType = Types.valueOf(
                jsonObject.get("types").asJsonArray.get(1).asJsonObject.get("type").asJsonObject.get(
                    "name"
                ).asString.uppercase()
            )
        }
        return secondaryType
    }

    private fun getPrimaryTypeFromJson(jsonObject: JsonObject) =
        Types.valueOf(
            jsonObject.get("types").asJsonArray.get(0).asJsonObject.get("type").asJsonObject.get(
                "name"
            ).asString.uppercase()
        )

    private fun getAbilityFromJson(jsonObject: JsonObject): String =
        jsonObject.get("abilities").asJsonArray.get(0).asJsonObject.get("ability").asJsonObject.get(
            "name"
        ).asString.replaceFirstChar { it.uppercase() }

    private fun getIdFromJson(jsonObject: JsonObject) = jsonObject.get("id").asInt

    private fun getNameFromJson(jsonObject: JsonObject): String =
        jsonObject.get("name").asString.replaceFirstChar { it.uppercase() }

    private fun getWeightFromJson(jsonObject: JsonObject) = jsonObject.get("weight").asFloat

    private fun getHeightFromJson(jsonObject: JsonObject) = jsonObject.get("height").asFloat
}