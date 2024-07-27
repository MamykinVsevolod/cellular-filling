package com.example.cellular_filling.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cellular_filling.model.RectangleItem
import com.example.cellular_filling.model.RectangleType
import com.example.cellular_filling.ui.theme.Typography
import com.example.cellular_filling.ui.utils.getColorForType
import com.example.cellular_filling.ui.utils.getPictureForType
import com.example.cellular_filling.ui.utils.getTextForType

@Composable
fun RectangleItemView(rectangle: RectangleItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            .clip(
                RoundedCornerShape(8.dp)
            )
            .background(color = Color.White),
        contentAlignment = Alignment.CenterStart
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Box(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(40.dp)
                    .clip(shape = CircleShape)
                    .background(getColorForType(rectangle.type)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = getPictureForType(rectangle.type),
                    contentDescription = "Picture",
                    modifier = Modifier.size(20.dp).fillMaxSize(),
                    alignment = Alignment.Center
                )
            }
            Column(
                modifier = Modifier
                    //.fillMaxHeight()
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                val (title, text) = getTextForType(rectangle.type)
                Text(text = title, style = Typography.bodyMedium)
                Text(text = text, style = Typography.bodySmall)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewRectangleItemView() {
    RectangleItemView(
        rectangle = RectangleItem(
            id = 1,
            type = RectangleType.DEAD
        )
    )
}