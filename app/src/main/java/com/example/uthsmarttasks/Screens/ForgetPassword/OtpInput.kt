package com.example.uthsmarttasks.Screens.ForgetPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OtpInput(
    otpLength: Int = 6,
    onFilled: (String) -> Unit
) {
    var otpValue by remember { mutableStateOf("") }

    // BasicTextField ẩn, dùng để bắt nhập
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Focus vào TextField */ },
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = otpValue,
            onValueChange = {
                if (it.length <= otpLength && it.all { c -> c.isDigit() }) {
                    otpValue = it
                    if (it.length == otpLength) onFilled(it)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            decorationBox = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(otpLength) { index ->
                        val char = otpValue.getOrNull(index)?.toString() ?: ""
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFF5F5F5))
                                .border(
                                    1.dp,
                                    if (index == otpValue.length) Color(0xFF2196F3)
                                    else Color.LightGray,
                                    RoundedCornerShape(8.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = char,
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        )
    }
}