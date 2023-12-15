package com.example.pokedex.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.PokemonAPIRepositoryImpl
import com.example.pokedex.data.PokemonRepositoryJSONImpl
import com.example.pokedex.data.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application.applicationContext

    private val pokemonRepositoryJson: PokemonRepositoryJSONImpl = PokemonRepositoryJSONImpl()

    private val pokemonAPIRepositoryImpl: PokemonAPIRepositoryImpl = PokemonAPIRepositoryImpl()

    private var _pokemon: MutableLiveData<Pokemon> = MutableLiveData<Pokemon>()

    val pokemon: LiveData<Pokemon> = _pokemon

    fun loadPokemon(name: String) {
        viewModelScope.launch {
            _pokemon.postValue(withContext(Dispatchers.IO) {
                pokemonAPIRepositoryImpl.getPokemon(name)
            }
            )
        }
    }
}