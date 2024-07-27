package com.example.cellular_filling.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.cellular_filling.R
import com.example.cellular_filling.model.RectangleType

@Composable
fun getPictureForType(type: RectangleType): Painter {
    return when (type) {
        RectangleType.ALIVE -> painterResource(R.drawable.alive)
        RectangleType.DEAD -> painterResource(R.drawable.dead)
        else -> painterResource(R.drawable.life)
    }
}
