package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.PokemonAPIRepositoryImpl
import com.example.pokedex.data.model.PokemonList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonListViewModel() : ViewModel() {

    private val pokemonAPIRepositoryImpl: PokemonAPIRepositoryImpl = PokemonAPIRepositoryImpl()

    private var _pokemonList: MutableLiveData<PokemonList> = MutableLiveData<PokemonList>()

    val pokemonList: LiveData<PokemonList> = _pokemonList

    init {
        viewModelScope.launch {
            _pokemonList.postValue(
                withContext(Dispatchers.IO) {
                    pokemonAPIRepositoryImpl.getPokemonList(10000)
                }
            )
        }
    }
}