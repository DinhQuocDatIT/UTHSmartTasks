package com.example.uthsmarttasks.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uthsmarttasks.R
import com.example.uthsmarttasks.ui.theme.colorCustom

@Composable
fun PasswordChangInterface(
    logo:Int,nameApp:String ,title:String,content:String
){
    Column(modifier = Modifier.fillMaxWidth().padding(top=50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(logo),
            contentDescription = nameApp,
            modifier = Modifier.size(150.dp)
        )
        Text((nameApp), color = colorCustom.colorBrand, fontSize = 25.sp, fontWeight = FontWeight.Bold)
    }

    Text((title), color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    Text((content), color = Color(0xFF6C6C6C), fontSize = 16.sp, textAlign = TextAlign.Center)
}