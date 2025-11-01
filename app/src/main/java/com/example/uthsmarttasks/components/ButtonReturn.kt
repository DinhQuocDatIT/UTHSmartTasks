package com.example.uthsmarttasks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uthsmarttasks.ui.theme.colorCustom

@Composable
fun ButtonReturn (
    onClick:()->Unit
){
    Row (){
        IconButton(onClick = onClick,modifier = Modifier.clip(shape = RoundedCornerShape(15.dp)).clip(shape = RoundedCornerShape(10.dp)).background(colorCustom.primary)) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Quay về",
                tint = Color.White,
                modifier = Modifier.size(24.dp).background(Color.Transparent)
            )
        }
    }
}
