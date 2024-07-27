package com.example.cellular_filling.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.cellular_filling.model.RectangleItem
import com.example.cellular_filling.model.RectangleType

class MainViewModel : ViewModel() {
    var items = mutableStateListOf<RectangleItem>()

    private var nextId: Long = items.maxOfOrNull { it.id }?.plus(1) ?: 1
    private var counterOfAlive = 0
    private var counterOfDead = 0

    fun addItem() {
        val type = getRandomRectangleType()
        updateCounters(type)

        addRectangleItem(type)

        if (shouldAddLifeItem()) {
            addLifeRectangleItem()
        } else if (shouldChangeLastLifeToDeath()) {
            changeLastLifeToDeath()
        }
    }

    private fun updateCounters(type: RectangleType) {
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
    }

    private fun shouldAddLifeItem(): Boolean {
        return counterOfAlive == 3
    }

    private fun addRectangleItem(type: RectangleType) {
        val newItem = RectangleItem(id = nextId, type = type)
        items.add(newItem)
        nextId++
    }

    private fun addLifeRectangleItem() {
        counterOfAlive = 0
        val newItemLife = RectangleItem(id = nextId, type = RectangleType.LIFE)
        items.add(newItemLife)
        nextId++
    }

    private fun shouldChangeLastLifeToDeath(): Boolean {
        return counterOfDead == 3
    }

    private fun changeLastLifeToDeath() {
        val lastLifeIndex = items.indexOfLast { it.type == RectangleType.LIFE }
        if (lastLifeIndex != -1) {
            items[lastLifeIndex] = items[lastLifeIndex].copy(type = RectangleType.DEATH)
        }
    }

    private fun getRandomRectangleType(): RectangleType {
        val selectedTypes = listOf(RectangleType.ALIVE, RectangleType.DEAD)
        return selectedTypes.random()
    }
}
