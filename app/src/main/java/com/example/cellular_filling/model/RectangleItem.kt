package com.example.cellular_filling.model

import kotlinx.serialization.Serializable

@Serializable
data class RectangleItem(
    val id: Long,
    var type: RectangleType
)