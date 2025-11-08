package com.example.uthsmarttasks.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uthsmarttasks.R
import androidx.navigation.NavController
import com.example.uthsmarttasks.navigation.Screen


import com.example.uthsmarttasks.ui.theme.colorCustom
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(Screen.OnboardingScreen){
            popUpTo(Screen.SplashScreen) { inclusive=true }
        }
    }
    Column(modifier = Modifier.fillMaxSize().background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Image(
            painter = painterResource(R.drawable.logouth),
            contentDescription = "Logo UTH",
            modifier = Modifier.size(150.dp)
        )

       Text("UTH SmartTask", color = colorCustom.colorBrand, fontSize = 30.sp, fontWeight = FontWeight.Bold
       )

    }

}