package com.example.pokedex.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.viewmodels.SearchBarViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(searchBarViewModel: SearchBarViewModel) {
    val active by searchBarViewModel.active.observeAsState()
    val searchHistory by searchBarViewModel.searchHistory.observeAsState()
    val query by searchBarViewModel.query.observeAsState()
    

    if(query != null && searchHistory != null) {

        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = if (active == true) 0.dp else 8.dp,
                    vertical = if (active == true) 0.dp else 8.dp
                ),
            query = query!!,
            onQueryChange = {
                searchBarViewModel.setActualQuery(it)
            },
            onSearch = {
                searchBarViewModel.setActive(false)
                searchBarViewModel.addToHistory(it)
            },
            colors = SearchBarDefaults.colors(
                containerColor = Color.White,
                inputFieldColors = myTextFieldColors()
            ),
            active = active!!,
            onActiveChange = { searchBarViewModel.setActive(it) },
            placeholder = {
                Text(text = "Search", color = Color.Black)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        ) {
            searchHistory!!.forEach {
                if (it != "") {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 14.dp)
                        .clickable { searchBarViewModel.setActualQuery(it) }) {
                        Icon(imageVector = Icons.Default.History, contentDescription = null)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = it)
                    }
                }
            }
        }
    }
}