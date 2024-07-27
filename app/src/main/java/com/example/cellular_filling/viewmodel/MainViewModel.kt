package com.example.cellular_filling.viewmodel

import android.util.Log
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
        Log.d("MyListView_1", items.size.toString())
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
        Log.d("MyListView_2", items.size.toString())
        if (counterOfAlive == 3) {
            val newItem = RectangleItem(id = nextId, type = type)
            items.add(newItem)
            nextId++
            type = RectangleType.LIFE
            counterOfAlive = 0
            val newItemLife = RectangleItem(id = nextId, type = type)
            items.add(newItemLife)
            nextId++
        } else if (counterOfDead == 3) {
            val newItem = RectangleItem(id = nextId, type = type)
            items.add(newItem)
            nextId++
            val lastLifeIndex = items.indexOfLast { it.type == RectangleType.LIFE }
            if (lastLifeIndex != -1) {
                items[lastLifeIndex] = items[lastLifeIndex].copy(type = RectangleType.DEATH)
            }
        } else {
            val newItem = RectangleItem(id = nextId, type = type)
            items.add(newItem)
            nextId++
        }

        Log.d("MyListView_3", items.size.toString())
    }

    private fun getRandomRectangleType(): RectangleType {
        val selectedTypes = listOf(RectangleType.ALIVE, RectangleType.DEAD)
        return selectedTypes.random()
    }
}