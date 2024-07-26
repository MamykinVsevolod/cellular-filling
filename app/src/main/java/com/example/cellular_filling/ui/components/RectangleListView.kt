package com.example.cellular_filling.ui.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.cellular_filling.model.RectangleItem
import com.example.cellular_filling.model.RectangleType
import kotlinx.coroutines.delay

@Composable
fun RectangleListView(items: List<RectangleItem>) {
    Log.d("MyListRec", items.size.toString())
    val visibleItems = remember { mutableSetOf<RectangleItem>() }
    LazyColumn() {
        items(items.size) { index ->
            val item = items[index]
            var isVisible by remember { mutableStateOf(item in visibleItems) }
            if (item.type != RectangleType.DEATH) {
                AnimatedVisibility(
                    visible = isVisible,
                    enter = fadeIn() + expandHorizontally()
                ) {
                    RectangleItemView(rectangle = item)
                }
            } else RectangleItemView(rectangle = item)
            LaunchedEffect(item) {
                if (item !in visibleItems) {
                    if (item.type == RectangleType.LIFE) {
                        delay(500)
                    }
                    isVisible = true
                    visibleItems.add(item)
                } else {
                    isVisible = true
                }
            }
        }
    }
}