package com.example.uthsmarttasks.Navigation
import androidx.lifecycle.viewmodel.compose.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uthsmarttasks.Data.ViewModel.ForgotPasswordViewModel
import com.example.uthsmarttasks.Screens.ForgetPassword.Confirm
import com.example.uthsmarttasks.Screens.ForgetPassword.CreateNewPassword
import com.example.uthsmarttasks.Screens.ForgetPassword.ForgotPasswordEmailScreen
import com.example.uthsmarttasks.Screens.ForgetPassword.VerifyCode
import com.example.uthsmarttasks.Screens.Home
import com.example.uthsmarttasks.Screens.Introduce.OnboardingScreen
import com.example.uthsmarttasks.Screens.SplashScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    val forgotPasswordViewModel: ForgotPasswordViewModel = viewModel()
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
        composable(Screen.ForgotPasswordEmailScreen) {
            ForgotPasswordEmailScreen(
                viewModel = forgotPasswordViewModel,
                navController = navController)
        }
        composable(Screen.VerifyCode) {
            VerifyCode(viewModel = forgotPasswordViewModel,navController = navController)
        }
        composable(Screen.CreateNewPassword) {

            CreateNewPassword(viewModel = forgotPasswordViewModel,navController = navController)
        }
        composable(Screen.Confirm) {
            Confirm(viewModel = forgotPasswordViewModel,navController = navController)
        }

    }

}