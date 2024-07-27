package com.example.cellular_filling.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.cellular_filling.ui.components.RectangleListView
import com.example.cellular_filling.ui.components.MyButton
import com.example.cellular_filling.ui.components.MyTitle
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 72.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyTitle()
            RectangleListView(items = viewModel.items)
        }
        MyButton(viewModel = viewModel)
    }
}
