package com.example.cellular_filling.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cellular_filling.R
import com.example.cellular_filling.model.RectangleItem
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

@Composable
fun getPictureForType(type: RectangleType): Painter {
    return when (type) {
        RectangleType.ALIVE -> painterResource(R.drawable.alive)
        RectangleType.DEAD -> painterResource(R.drawable.dead)
        else -> painterResource(R.drawable.life)
    }
}

@Composable
fun RectangleItemView(rectangle: RectangleItem) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .background(color = Color.White)
            .clip(
                RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomStart = 8.dp,
                    bottomEnd = 8.dp
                )
            )
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .padding(start = 16.dp)
                .clip(shape = CircleShape)
                .background(getColorForType(type = rectangle.type))
        ) {
            Image(
                painter = getPictureForType(type = rectangle.type),
                contentDescription = "Picture",
                modifier = Modifier.size(40.dp)
            )
        }
        Column(modifier = Modifier
            .padding(start = 16.dp)){

        }
    }
}