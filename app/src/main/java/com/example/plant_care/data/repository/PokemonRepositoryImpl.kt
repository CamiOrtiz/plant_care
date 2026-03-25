package com.example.plant_care.data.repository

import com.example.plant_care.data.repository.remote.dto.PokemonApiService
import com.example.plant_care.domain.model.Pokemon
import com.example.plant_care.domain.model.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val api: PokemonApiService
) : PokemonRepository {

    // ✅ La función va AQUÍ, dentro de la clase, no en el constructor
    override suspend fun getPokemon(): List<Pokemon> {
        // Primero obtenemos la lista básica
        val response = api.getPokemonList()
        println("📦 Response: ${response.results.size} items") //

        val pokemonList = mutableListOf<Pokemon>()

        for (pokemonDto in response.results) {
            try {
                val detail = api.getPokemonDetail(pokemonDto.name)
                println("✅ Detail: ${detail.name}") // 👈 y esto
                val pokemon = Pokemon(
                    id = detail.id,
                    name = detail.name,
                    height = detail.height,
                    weight = detail.weight,
                    types = detail.types.map { it.type.name },
                    spriteUrl = detail.sprites.front_default
                )
                pokemonList.add(pokemon)
            } catch (e: Exception) {
                println("❌ Error en ${pokemonDto.name}: ${e.message}") // 👈 y esto
            }
        }

        return pokemonList
    }

}