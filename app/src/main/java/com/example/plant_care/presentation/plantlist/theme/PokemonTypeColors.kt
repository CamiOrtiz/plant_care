package com.example.plant_care.presentation.theme

import androidx.compose.ui.graphics.Color

fun typeColor(type: String): Color = when (type) {
    "grass" -> Color(0xFF4CAF82)
    "poison" -> Color(0xFFAB7BC8)
    "fire" -> Color(0xFFFF6F3C)
    "water" -> Color(0xFF4FC3F7)
    "bug" -> Color(0xFF8BC34A)
    "normal" -> Color(0xFFA8A878)
    "electric" -> Color(0xFFFFD54F)
    "ground" -> Color(0xFFE0C068)
    "fairy" -> Color(0xFFF4A7C3)
    "psychic" -> Color(0xFFF06292)
    "fighting" -> Color(0xFFD32F2F)
    "rock" -> Color(0xFFB5A040)
    "ghost" -> Color(0xFF7B62A3)
    "ice" -> Color(0xFF80DEEA)
    "dragon" -> Color(0xFF7038F8)
    "dark" -> Color(0xFF705848)
    "steel" -> Color(0xFFB8B8D0)
    "flying" -> Color(0xFF9DB7F5)
    else -> Color(0xFF888780)
}