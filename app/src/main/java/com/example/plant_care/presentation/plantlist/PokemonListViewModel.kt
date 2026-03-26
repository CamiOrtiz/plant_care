package com.example.plant_care.presentation.plantlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plant_care.domain.model.Pokemon
import com.example.plant_care.domain.model.usecase.GetPokemonsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _allpokemon = MutableStateFlow<List<Pokemon>>(emptyList())
    private val _searchQuery = MutableStateFlow("")
    private val _selectedTypes = MutableStateFlow<Set<String>>(emptySet())

    val searchQuery: StateFlow<String> = _searchQuery
    val selectedTypes: StateFlow<Set<String>> = _selectedTypes

    // 👇 tipos disponibles se calculan de la lista cargada
    val availableTypes: StateFlow<List<String>> = _allpokemon.map { list ->
        list.flatMap { it.types }.distinct().sorted()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val pokemon: StateFlow<List<Pokemon>> = combine(
        _allpokemon, _searchQuery, _selectedTypes
    ) { list, query, types ->
        list
            .filter { if (query.isBlank()) true else it.name.contains(query, ignoreCase = true) }
            .filter { if (types.isEmpty()) true else it.types.any { t -> t in types } }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )


    init {
        loadPokemon()
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onTypeSelected(type: String) {
        _selectedTypes.value = _selectedTypes.value.toMutableSet().apply {
            if (contains(type)) remove(type) else add(type)
        }
    }

    private fun loadPokemon() {
        viewModelScope.launch {
            try {
                val result = getPokemonsUseCase()
                _allpokemon.value = result
                println("Pokemons cargados : ${result.size}")
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }

        }
    }
}