package com.example.uthsmarttasks.Screens.Introduce

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.uthsmarttasks.Data.Module.Introduce

@Composable
fun OnboardingPageItem(page : Introduce){
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Image(
            painter = painterResource(page.image),
            contentDescription = "${page.title}",
            modifier = Modifier.fillMaxWidth().height(300.dp)
        )
        Text((page.title), fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)
        Text((page.content),fontSize = 16.sp, color = Color.Black , textAlign = TextAlign.Center)

    }
}