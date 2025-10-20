package com.example.uthsmarttasks.Screens.Introduce

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uthsmarttasks.ui.theme.colorCustom

@Composable

fun PageIndicator(currentPage: Int, pageCount: Int) {
        Row(horizontalArrangement = Arrangement.Center) {
            repeat(pageCount) { index ->
                val color = if (index == currentPage) colorCustom.primary else Color.Gray
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(color)
                )
            }
        }
    }