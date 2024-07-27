package com.example.cellular_filling.model

import kotlinx.serialization.Serializable

@Serializable
enum class RectangleType {
    ALIVE,
    DEAD,
    LIFE,
    DEATH
}
