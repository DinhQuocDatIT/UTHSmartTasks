package com.example.uthsmarttasks.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uthsmarttasks.Screens.Home
import com.example.uthsmarttasks.Screens.Introduce.OnboardingScreen
import com.example.uthsmarttasks.Screens.SplashScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen){
        composable (Screen.SplashScreen){
            SplashScreen(navController = navController)
        }
        composable(Screen.Home){
            Home(navController = navController)
        }
        composable(Screen.OnboardingScreen) {
            OnboardingScreen(navController = navController)
        }
    }

}