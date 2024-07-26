package com.example.cellular_filling.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cellular_filling.R
import com.example.cellular_filling.ui.components.RectangleListView
import com.example.cellular_filling.ui.theme.ButtonColor
import com.example.cellular_filling.ui.theme.Typography
import com.example.cellular_filling.ui.theme.MainColor1
import com.example.cellular_filling.ui.theme.MainColor2
import com.example.cellular_filling.viewmodel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(MainColor1, MainColor2)
                )
            )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.main_title),
                style = Typography.bodyMedium,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp, bottom = 22.dp)
            )
            RectangleListView(items = viewModel.items)
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    onClick = { viewModel.addItem() },
                    shape = RoundedCornerShape(4.dp),
                    colors =  ButtonDefaults.buttonColors(
                        containerColor = ButtonColor
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                        .padding(start = 14.dp, end = 14.dp)
                        .clip(
                            RoundedCornerShape(4.dp)
                        )
                ) {
                    Text(text = stringResource(R.string.button), style = Typography.bodyMedium, fontSize = 14.sp)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    val viewModel = MainViewModel()
    MainScreen(viewModel)
}