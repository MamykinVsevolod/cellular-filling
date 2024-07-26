package com.example.cellular_filling.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.cellular_filling.model.RectangleItem
import com.example.cellular_filling.model.RectangleType

class MainViewModel : ViewModel() {
    private var nextId: Long = 1
    private var counterOfAlive = 0
    private var counterOfDead = 0
    var items = mutableStateListOf<RectangleItem>()

    fun addItem() {
        var type = getRandomRectangleType()
        when (type) {
            RectangleType.ALIVE -> {
                counterOfAlive++
                counterOfDead = 0
            }

            RectangleType.DEAD -> {
                counterOfDead++
                counterOfAlive = 0
            }

            else -> {}
        }
        if (counterOfAlive == 3) {
            val newItem = RectangleItem(
                id = nextId,
                type = type
            )
            items.add(newItem)
            nextId++
            type = RectangleType.LIFE
            counterOfAlive = 0
            val newItemLife = RectangleItem(
                id = nextId,
                type = type
            )
            items.add(newItemLife)
            nextId++
        } else if (counterOfDead == 3) {
            val newItem = RectangleItem(
                id = nextId,
                type = type
            )
            items.add(newItem)
            nextId++
            val lastLifeIndex = items.indexOfLast { it.type == RectangleType.LIFE }
            if (lastLifeIndex != -1) {
                items[lastLifeIndex] = items[lastLifeIndex].copy(type = RectangleType.DEATH)
            }
        } else {
            val newItem = RectangleItem(
                id = nextId,
                type = type
            )
            items.add(newItem)
            nextId++
        }
    }

    private fun getRandomRectangleType(): RectangleType {
        val selectedTypes = listOf(RectangleType.ALIVE, RectangleType.DEAD)
        return selectedTypes.random()
    }
}