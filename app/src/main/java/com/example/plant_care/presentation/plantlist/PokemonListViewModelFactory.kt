package com.example.plant_care.presentation.plantlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.plant_care.domain.model.usecase.GetPokemonsUseCase

class PokemonListViewModelFactory(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PokemonListViewModel(getPokemonsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}