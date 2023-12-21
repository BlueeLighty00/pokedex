package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.IPokemonRepository
import com.example.pokedex.data.PokemonAPIRepositoryImpl
import com.example.pokedex.data.model.PokemonList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonRepository: IPokemonRepository
) : ViewModel() {

    private var _pokemonList: MutableLiveData<PokemonList> = MutableLiveData<PokemonList>()

    val pokemonList: LiveData<PokemonList> = _pokemonList

    init {
        viewModelScope.launch {
            _pokemonList.postValue(
                withContext(Dispatchers.IO) {
                    pokemonRepository.getPokemonList(10000)
                }
            )
        }
    }
}