package com.example.cellular_filling.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.cellular_filling.model.RectangleItem
import com.example.cellular_filling.model.RectangleType

class MainViewModel : ViewModel() {
    private var nextId : Long = 1
    val items = mutableStateListOf<RectangleItem>()

    fun addItem() {
        val newItem = RectangleItem(
            id = nextId,
            type = getRandomRectangleType()
        )
        items.add(newItem)
        nextId++
    }

    private fun getRandomRectangleType(): RectangleType {
        val selectedTypes = listOf(RectangleType.ALIVE, RectangleType.DEAD)
        return selectedTypes.random()
    }
}