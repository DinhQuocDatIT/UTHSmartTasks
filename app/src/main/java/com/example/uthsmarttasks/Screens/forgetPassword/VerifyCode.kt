package com.example.uthsmarttasks.Screens.forgetPassword

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uthsmarttasks.data.viewModel.ForgotPasswordViewModel
import com.example.uthsmarttasks.navigation.Screen
import com.example.uthsmarttasks.R
import com.example.uthsmarttasks.components.ButtonReturn
import com.example.uthsmarttasks.components.PasswordChangInterface
import com.example.uthsmarttasks.ui.theme.colorCustom

@Composable
fun VerifyCode(viewModel: ForgotPasswordViewModel, navController: NavController){
    val forgotPassword = viewModel.forgotPassword.value
    val context = LocalContext.current
    var otpCode by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize().background(color = Color.White).padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)) {
        ButtonReturn(onClick = {
            navController.popBackStack()
        })
        PasswordChangInterface(
            logo = R.drawable.logouth,
            nameApp = "SmartTask",
            title = "Verify Code",
            content = "Enter your email,we will send you a verification code"
        )
        OtpInput(onFilled = { code ->
            otpCode = code
        })

        Button(onClick = {
            if (otpCode.length == 6) { // ví dụ OTP 6 chữ số
                viewModel.forgotPassword.value = viewModel.forgotPassword.value.copy(
                    verificationCode = otpCode
                )
                navController.navigate(Screen.CreateNewPassword)
            } else {
                Toast.makeText(context, "Please enter a valid OTP", Toast.LENGTH_SHORT).show()
            }
        },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorCustom.primary
            )) {

            Text("Next",fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(5.dp))
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun VerifyCodePreview() {
//    UthsmarttasksTheme {
//        VerifyCode(rememberNavController())
//    }
//}