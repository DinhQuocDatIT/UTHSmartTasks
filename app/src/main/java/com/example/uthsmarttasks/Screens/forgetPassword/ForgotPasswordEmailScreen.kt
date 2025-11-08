package com.example.uthsmarttasks.Screens.forgetPassword

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.uthsmarttasks.components.PasswordChangInterface
import com.example.uthsmarttasks.ui.theme.colorCustom

@Composable
fun ForgotPasswordEmailScreen(viewModel: ForgotPasswordViewModel,navController: NavController){

    val forgotPassword = viewModel.forgotPassword.value
    var isError by remember { mutableStateOf(false) }
    val context = LocalContext.current

    fun isValidEmail(input: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }
    Column(modifier = Modifier.fillMaxSize().background(color = Color.White).padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)) {
        PasswordChangInterface(
            logo = R.drawable.logouth,
            nameApp = "SmartTask",
            title = "Verify Code",
            content = "we just sent you on your registered Email"
        )
        OutlinedTextField(
            value = forgotPassword.email,
            onValueChange = {newEmail ->
                viewModel.forgotPassword.value = forgotPassword.copy(email = newEmail)},
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp) // khoảng cách giữa icon và text
                ) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        tint = Color(0xFFAFAFAF),
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Your Email",
                        fontSize = 16.sp,
                        color = Color(0xFFAFAFAF)
                    )
                }
            }
        )
        if (isError) {
            Text(text = "Email không hợp lệ!", color = Color.Red, fontSize = 14.sp)
        }
        Button(onClick = {
            if (isValidEmail(forgotPassword.email)) {
                navController.navigate(Screen.VerifyCode)
            } else {
                isError = true
                Toast.makeText(context, "Email không hợp lệ!", Toast.LENGTH_SHORT).show()
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
//fun ForgotPasswordEmailScreenPreview() {
//    UthsmarttasksTheme {
//        ForgotPasswordEmailScreen(rememberNavController())
//    }
//}