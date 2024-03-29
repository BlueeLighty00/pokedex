package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.usecases.GetPokemonInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonUseCase: GetPokemonInfoUseCase
) : ViewModel() {

    private var _pokemon: MutableLiveData<Pokemon> = MutableLiveData<Pokemon>()

    val pokemon: LiveData<Pokemon> = _pokemon

    fun loadPokemon(name: String) {
        viewModelScope.launch {
            _pokemon.postValue(withContext(Dispatchers.IO) {
                pokemonUseCase.getPokemonInfo(name)
            }
            )
        }
    }
}