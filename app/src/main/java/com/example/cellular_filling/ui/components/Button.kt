package com.example.cellular_filling.ui.components

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cellular_filling.R
import com.example.cellular_filling.ui.theme.ButtonColor
import com.example.cellular_filling.ui.theme.Typography
import com.example.cellular_filling.viewmodel.MainViewModel

@Composable
fun MyButton(viewModel: MainViewModel) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = { viewModel.addItem() },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
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
            Text(
                text = stringResource(R.string.button),
                style = Typography.bodyMedium,
                fontSize = 14.sp
            )
        }
    }
}