package com.example.plant_care.data.repository.remote.dto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: PokemonApiService by lazy {
        retrofit.create(PokemonApiService ::class.java)
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
