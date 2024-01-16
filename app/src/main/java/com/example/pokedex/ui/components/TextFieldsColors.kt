package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.theme.SelectionColor

@Composable
fun GenericTextFields(placeholder: String, value: String, onValueChange: (String) -> Unit) {

    TextField(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = placeholder) },
        colors = myTextFieldColors()
    )
}

@Composable
fun myTextFieldColors() = TextFieldDefaults.colors(
    focusedContainerColor = MaterialTheme.colorScheme.primary,
    unfocusedContainerColor = MaterialTheme.colorScheme.primary,
    disabledContainerColor = MaterialTheme.colorScheme.primary,
    focusedLabelColor = Color.Black,
    unfocusedLabelColor = Color.Black,
    disabledLabelColor = Color.Black,
    cursorColor = Color.Black,
    errorCursorColor = Color.Black,
    focusedTextColor = Color.Black,
    unfocusedTextColor = Color.Black,
    selectionColors = TextSelectionColors(handleColor = Color.Black, backgroundColor = SelectionColor)
)