package com.example.uthsmarttasks.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uthsmarttasks.ui.theme.colorCustom

@Composable
fun ButtonCustom (text:String,
    onClick:()->Unit
){
    Button(onClick = {onClick},
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorCustom.primary
        )) {

        Text(text=text, color = Color.White, modifier = Modifier.padding(10.dp,4.dp))
    }
}