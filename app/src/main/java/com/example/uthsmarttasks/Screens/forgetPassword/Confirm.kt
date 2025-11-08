package com.example.uthsmarttasks.Screens.forgetPassword

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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uthsmarttasks.data.viewModel.ForgotPasswordViewModel
import com.example.uthsmarttasks.navigation.Screen
import com.example.uthsmarttasks.R
import com.example.uthsmarttasks.components.ButtonReturn
import com.example.uthsmarttasks.components.PasswordChangInterface
import com.example.uthsmarttasks.ui.theme.colorCustom
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Eye
import compose.icons.fontawesomeicons.solid.EyeSlash


@Composable
fun Confirm(viewModel: ForgotPasswordViewModel ,navController: NavController){
    val forgotPassword = viewModel.forgotPassword.value
    var passwordVisible by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize().background(color = Color.White).padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)) {
        ButtonReturn(onClick = {
            navController.popBackStack()
        })
        PasswordChangInterface(
            logo = R.drawable.logouth,
            nameApp = "SmartTask",
            title = "Confirm",
            content = "We are here to help you"
        )
        OutlinedTextField(
            value = viewModel.forgotPassword.value.email,
            onValueChange = { },
            readOnly = true,
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
                }
            }
        )
        OutlinedTextField(
            value = viewModel.forgotPassword.value.verificationCode,
            onValueChange = { },
            readOnly = true,
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

                }
            }
        )
        OutlinedTextField(
            value = forgotPassword.password,
            onValueChange = {},
            readOnly = true,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible) FontAwesomeIcons.Solid.Eye else FontAwesomeIcons.Solid.EyeSlash
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = "Toggle password visibility",tint = Color.Black, modifier = Modifier.size(16.dp))
                }
            },
            placeholder = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null,
                        tint = Color(0xFFAFAFAF),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        )

        Button(onClick = {
            navController.navigate(Screen.ForgotPasswordEmailScreen)
        },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorCustom.primary
            )) {

            Text("Summit",fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(5.dp))
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun Confirm() {
//    UthsmarttasksTheme {
//        Confirm(rememberNavController())
//    }
//}