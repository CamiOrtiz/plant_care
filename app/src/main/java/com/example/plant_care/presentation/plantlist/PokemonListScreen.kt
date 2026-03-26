package com.example.plant_care.presentation.plantlist

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plant_care.presentation.plantlist.theme.typeColor

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel,
    onItemClick: (String) -> Unit
) {
    val pokemon by viewModel.pokemon.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedTypes by viewModel.selectedTypes.collectAsState()
    val availableTypes by viewModel.availableTypes.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 20.dp, end = 20.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            PokeballIcon(size = 36.dp)
            Spacer(modifier = Modifier.width(12.dp))
            val titleColor = if (isSystemInDarkTheme()) Color.White else Color.Black
            Text(
                text = "Pokédex",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = titleColor
            )
        }

        // Buscador
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.onSearchQueryChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            placeholder = { Text("Buscar pokémon...") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { viewModel.onSearchQueryChange("") }) {
                        Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp)
        )

        // 👇 Chips de tipo con scroll horizontal pegados a la derecha
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            reverseLayout = true // 👈 esto los pega al final (derecha)
        ) {
            items(availableTypes) { type ->
                val isSelected = type in selectedTypes
                val typeCol = typeColor(type)

                FilterChip(
                    selected = isSelected,
                    onClick = { viewModel.onTypeSelected(type) },
                    label = {
                        Text(
                            text = type,
                            fontSize = 12.sp,
                            color = if (isSelected) Color.White else typeCol
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = typeCol,
                        containerColor = typeCol.copy(alpha = 0.15f)
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = isSelected,
                        borderColor = typeCol.copy(alpha = 0.5f),
                        selectedBorderColor = typeCol
                    )
                )
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        ) {
            items(pokemon) { item ->
                PokemonItem(
                    pokemon = item,
                    onClick = { onItemClick(item.name) }
                )
            }
        }
    }
}