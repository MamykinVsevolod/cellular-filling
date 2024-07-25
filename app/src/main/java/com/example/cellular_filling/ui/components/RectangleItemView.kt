package com.example.cellular_filling.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cellular_filling.model.RectangleItem


@Composable
fun RectangleItemView(rectangle: RectangleItem) {
    Row(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .background(color = Color.White)
        .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp, bottomStart = 8.dp, bottomEnd = 8.dp))
    ){
        
    }
}