package com.example.plant_care.presentation.plantlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plant_care.domain.model.Pokemon
import com.example.plant_care.domain.model.usecase.GetPokemonsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _pokemon = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemon: StateFlow<List<Pokemon>> = _pokemon

    init {
        loadPokemon()
    }

    private fun loadPokemon() {
        viewModelScope.launch {
            try {
                val result = getPokemonsUseCase()
                _pokemon.value = result
                println("Pokemons cargados : ${result.size}")
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }

        }
    }
}