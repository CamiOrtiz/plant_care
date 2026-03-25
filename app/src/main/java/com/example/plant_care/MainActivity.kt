package com.example.plant_care

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plant_care.presentation.plantlist.PokemonListScreen
import com.example.plant_care.presentation.plantlist.PokemonListViewModel
import com.example.plant_care.presentation.plantlist.PokemonListViewModelFactory
import com.example.plant_care.domain.model.usecase.GetPokemonsUseCase
import com.example.plant_care.data.repository.PokemonRepositoryImpl
import com.example.plant_care.data.repository.remote.dto.RetrofitInstance
import com.example.plant_care.domain.model.Pokemon
import com.example.plant_care.presentation.plantlist.PokemonDetailScreen
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Dependencias
        val api = RetrofitInstance.api
        val repository = PokemonRepositoryImpl(api)
        val useCase = GetPokemonsUseCase(repository)
        val factory = PokemonListViewModelFactory(useCase)

        //Viewmodel

        val viewModel = ViewModelProvider(this, factory) [PokemonListViewModel::class.java]

        setContent{
            //NavController
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "list"
            ) {
                //Ruta "list" que muestra la lista de pokemons
                composable("list") {
                    PokemonListScreen(
                        viewModel = viewModel,
                        onItemClick = { pokemonName ->
                            navController.navigate("detail/$pokemonName")
                        }
                    )
                }
                //Ruta "detail/{name} -> recibe el nombre como argumento
                composable("detail/{name}"){ backStackEntry ->
                    val name = backStackEntry.arguments?.getString("name") ?: ""
                    val pokemons by viewModel.pokemon.collectAsState()
                    val pokemon = pokemons.find { it.name == name }

                    if (pokemon != null) {
                        PokemonDetailScreen(
                            pokemon = pokemon,
                            onBack = { navController.popBackStack() }
                        )

                }
            }

        }

    }
}
}