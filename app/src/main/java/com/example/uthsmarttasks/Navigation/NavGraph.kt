package com.example.uthsmarttasks.Navigation
import androidx.activity.compose.LocalActivity
import androidx.lifecycle.viewmodel.compose.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uthsmarttasks.Auth.Login
import com.example.uthsmarttasks.Data.ViewModel.ForgotPasswordViewModel
import com.example.uthsmarttasks.Screens.ForgetPassword.Confirm
import com.example.uthsmarttasks.Screens.ForgetPassword.CreateNewPassword
import com.example.uthsmarttasks.Screens.ForgetPassword.ForgotPasswordEmailScreen
import com.example.uthsmarttasks.Screens.ForgetPassword.VerifyCode
import com.example.uthsmarttasks.Screens.Home
import com.example.uthsmarttasks.Screens.Introduce.OnboardingScreen
import com.example.uthsmarttasks.Screens.SplashScreen
import com.example.uthsmarttasks.Auth.GoogleSignInManager
import com.example.uthsmarttasks.Auth.ProfileScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    val forgotPasswordViewModel: ForgotPasswordViewModel = viewModel()
    val activity = LocalActivity.current
    // ✅ Khởi tạo GoogleSignInManager 1 lần
    val googleSignInManager = remember(activity) {
        activity?.let { GoogleSignInManager(it) }
    }
    NavHost(navController = navController, startDestination = Screen.Login){
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
        composable(Screen.Login) {
            Login(
                onLoginSuccess = {
                    navController.navigate("profile") {
                        popUpTo(Screen.Login) { inclusive = true }
                    }
                },
                googleSignInManager = googleSignInManager!!,
                navController = navController
            )
        }
        composable(Screen.Profile) {
            ProfileScreen()
        }
    }

}