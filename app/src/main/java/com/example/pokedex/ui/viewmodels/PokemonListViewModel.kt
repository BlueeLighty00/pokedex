package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.usecases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val listUseCase: GetPokemonListUseCase
) : ViewModel() {

    private var _pokemonList: MutableLiveData<PokemonList> = MutableLiveData<PokemonList>()

    private var _pokemonListFiltered: MutableLiveData<ArrayList<String>> = MutableLiveData()

    val pokemonListFiltered: LiveData<ArrayList<String>> = _pokemonListFiltered

    init {
        viewModelScope.launch {
            _pokemonList.value =
                withContext(Dispatchers.IO) {
                    listUseCase.getList(100000)
                }
            _pokemonListFiltered.value = _pokemonList.value?.pokemonList?.clone() as ArrayList<String>
        }
    }

    fun filterList(query: String){
        val lista: ArrayList<String> = ArrayList()
        if(query.isBlank()){
            _pokemonListFiltered.value = _pokemonList.value?.pokemonList?.clone() as ArrayList<String>
        }else{
            _pokemonList.value?.pokemonList?.forEach {
                if(it.contains(query)) {
                    lista.add(it)
                }
            }
            _pokemonListFiltered.value = lista
        }
    }
}