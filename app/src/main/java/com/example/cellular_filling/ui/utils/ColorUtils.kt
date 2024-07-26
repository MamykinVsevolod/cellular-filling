package com.example.cellular_filling.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import com.example.cellular_filling.model.RectangleType
import com.example.cellular_filling.ui.theme.ColorAlive1
import com.example.cellular_filling.ui.theme.ColorAlive2
import com.example.cellular_filling.ui.theme.ColorDead1
import com.example.cellular_filling.ui.theme.ColorDead2
import com.example.cellular_filling.ui.theme.ColorDeath1
import com.example.cellular_filling.ui.theme.ColorDeath2
import com.example.cellular_filling.ui.theme.ColorLife1
import com.example.cellular_filling.ui.theme.ColorLife2

@Composable
fun getColorForType(type: RectangleType): Brush {
    return when (type) {
        RectangleType.ALIVE -> Brush.verticalGradient(
            colors = listOf(ColorAlive1, ColorAlive2)
        )

        RectangleType.DEAD -> Brush.verticalGradient(
            colors = listOf(ColorDead1, ColorDead2)
        )

        RectangleType.LIFE -> Brush.verticalGradient(
            colors = listOf(ColorLife1, ColorLife2)
        )

        RectangleType.DEATH -> Brush.verticalGradient(
            colors = listOf(ColorDeath1, ColorDeath2)
        )
    }
}