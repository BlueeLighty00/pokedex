package com.example.pokedex.data.sources.remote.api

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "Accept: application/json"
    )
    @GET("pokemon/{name}")
    suspend fun getPokemonData(@Path("name") name: String): String

    @Headers(
        "Accept: application/json"
    )
    @GET("pokemon")
    suspend fun getListPokemon(@Query("limit") limit: Int): String
}
