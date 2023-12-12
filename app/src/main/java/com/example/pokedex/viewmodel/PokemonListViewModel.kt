package com.example.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.api.RetrofitInstance
import com.example.pokedex.data.model.PokemonList
import com.example.pokedex.data.model.getPokemonListFromApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonListViewModel(): ViewModel(){

    private var _pokemonList: MutableLiveData<PokemonList> = MutableLiveData<PokemonList>()

    val pokemonList: LiveData<PokemonList> = _pokemonList

    init {
        viewModelScope.launch {
            _pokemonList.postValue(
                withContext(Dispatchers.IO) {
                    getPokemonListFromApi(RetrofitInstance.api.getListPokemon(10000))
                }
            )
        }
    }
}