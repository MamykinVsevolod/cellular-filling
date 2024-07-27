package com.example.cellular_filling.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.cellular_filling.model.RectangleItem
import com.example.cellular_filling.model.RectangleType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val ITEMS_KEY = "items_key"

    private val _items = mutableStateListOf<RectangleItem>().apply {
        restoreItems() // Восстановление данных при создании ViewModel
    }
    val items: List<RectangleItem> get() = _items

    private var nextId: Long = _items.maxOfOrNull { it.id }?.plus(1) ?: 1
    private var counterOfAlive = 0
    private var counterOfDead = 0

    private fun getItemsAsList(): List<RectangleItem> = _items.toList()
    private fun setItemsFromList(items: List<RectangleItem>) {
        _items.clear()
        _items.addAll(items)
    }

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
            _items.add(newItem)
            nextId++
            type = RectangleType.LIFE
            counterOfAlive = 0
            val newItemLife = RectangleItem(id = nextId, type = type)
            _items.add(newItemLife)
            nextId++
        } else if (counterOfDead == 3) {
            val newItem = RectangleItem(id = nextId, type = type)
            _items.add(newItem)
            nextId++
            val lastLifeIndex = _items.indexOfLast { it.type == RectangleType.LIFE }
            if (lastLifeIndex != -1) {
                _items[lastLifeIndex] = _items[lastLifeIndex].copy(type = RectangleType.DEATH)
            }
        } else {
            val newItem = RectangleItem(id = nextId, type = type)
            _items.add(newItem)
            nextId++
        }

        Log.d("MyListView_3", items.size.toString())
        try {
            // Сохранение элементов в SavedStateHandle как JSON
            val json = Json.encodeToString(getItemsAsList())
            Log.d("MyListView_4", "Serialized JSON: $json")
            savedStateHandle[ITEMS_KEY] = json
        } catch (e: Exception) {
            Log.e("MyListView_Error_1", "Error serializing items", e)
        }
    }

    private fun restoreItems() {
        val json = savedStateHandle.get<String>(ITEMS_KEY)
        json?.let {
            try {
                val items = Json.decodeFromString<List<RectangleItem>>(it)
                setItemsFromList(items)
                Log.d("MyListView_Restore", "Restored items: ${_items.size}")
            } catch (e: Exception) {
                Log.e("MyListView_Error_2", "Error restoring items", e)
            }
        }
    }

    private fun getRandomRectangleType(): RectangleType {
        val selectedTypes = listOf(RectangleType.ALIVE, RectangleType.DEAD)
        return selectedTypes.random()
    }
}