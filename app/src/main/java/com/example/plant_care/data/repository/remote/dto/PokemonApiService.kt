package com.example.plant_care.data.repository.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    @GET("api/v2/pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 150,
        @Query("offset") offset: Int = 0
    ): PokemonResponse

    //Necesitamos este endpoint para obtener los detalles de cada Pokémon
    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PokemonDetailDto
}