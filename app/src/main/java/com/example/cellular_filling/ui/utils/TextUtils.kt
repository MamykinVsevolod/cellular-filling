package com.example.cellular_filling.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.cellular_filling.R
import com.example.cellular_filling.model.RectangleType

@Composable
fun getTextForType(type: RectangleType): Pair<String, String> {
    return when (type) {
        RectangleType.ALIVE -> Pair(
            stringResource(R.string.alive_title),
            stringResource(R.string.alive_text)
        )

        RectangleType.DEAD -> Pair(
            stringResource(R.string.dead_title),
            stringResource(R.string.dead_text)
        )

        RectangleType.LIFE -> Pair(
            stringResource(R.string.life_title),
            stringResource(R.string.life_text)
        )

        RectangleType.DEATH -> Pair(
            stringResource(R.string.death_title),
            stringResource(R.string.death_text)
        )
    }
}
