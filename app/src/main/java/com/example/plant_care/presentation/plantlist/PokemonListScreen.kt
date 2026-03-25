package com.example.plant_care.presentation.plantlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel,
    onItemClick: (String) -> Unit
) {
    val pokemon by viewModel.pokemon.collectAsState()

    Column {
        Text("Pokédex")

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(pokemon) { item ->
                PokemonItem(
                    pokemon = item,
                    onClick = {
                        onItemClick(item.name)
                    }
                )
            }
        }
    }
}




