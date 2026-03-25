package com.example.plant_care.domain.model.usecase

import com.example.plant_care.domain.model.Pokemon
import com.example.plant_care.domain.model.repository.PokemonRepository

class GetPokemonsUseCase(
    private val repository: PokemonRepository
) {

    suspend operator fun invoke(): List<Pokemon> {
        return repository.getPokemon()
    }

}