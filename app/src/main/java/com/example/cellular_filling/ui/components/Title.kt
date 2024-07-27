package com.example.cellular_filling.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cellular_filling.R
import com.example.cellular_filling.ui.theme.Typography

@Composable
fun MyTitle() {
    Text(
        text = stringResource(R.string.main_title),
        style = Typography.bodyMedium,
        color = Color.White,
        modifier = Modifier.padding(top = 16.dp, bottom = 22.dp)
    )
}