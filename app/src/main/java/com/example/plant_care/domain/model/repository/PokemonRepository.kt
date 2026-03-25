package com.example.plant_care.domain.model.repository

import com.example.plant_care.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemon(): List<Pokemon>

}