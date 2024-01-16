package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchBarViewModel: ViewModel() {

    private var _searchHistory = MutableLiveData<MutableList<String>>(mutableListOf<String>())
    private var _active = MutableLiveData<Boolean>()
    private var _query = MutableLiveData<String>()

    val searchHistory: LiveData<MutableList<String>> = _searchHistory
    val active: LiveData<Boolean> = _active
    val query: LiveData<String> = _query


    init {
        _query.value = ""
        _active.value = false

    }

    fun addToHistory(query: String) {
        _searchHistory.value?.add(query)
    }

    fun setActualQuery(query: String) {
        _query.value = query
    }

    fun setActive(boolean: Boolean) {
        _active.postValue(boolean)
    }
}