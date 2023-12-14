package com.example.pokedex.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.api.RetrofitInstance
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.getPokemonFromApi
import com.example.pokedex.data.model.getPokemonFromJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    val context = application.applicationContext

    private var _pokemon: MutableLiveData<Pokemon> =
        MutableLiveData<Pokemon>(getPokemonFromJson(context))

    val pokemon: LiveData<Pokemon> = _pokemon

    fun setPokemon(name: String) {
        viewModelScope.launch {
            _pokemon.postValue(withContext(Dispatchers.IO) {
                getPokemonFromApi(RetrofitInstance.api.getPokemonData(name))
            }
            )
        }
    }
}