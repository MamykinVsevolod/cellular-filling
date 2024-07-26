package com.example.cellular_filling.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.cellular_filling.model.RectangleItem

@Composable
fun RectangleListView(items: List<RectangleItem>) {
    LazyColumn() {
        items(items.size) { index ->
            val item = items[index]
            RectangleItemView(rectangle = item)
        }
    }
}