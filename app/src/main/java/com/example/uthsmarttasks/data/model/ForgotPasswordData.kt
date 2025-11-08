package com.example.uthsmarttasks.data.model

data class ForgotPasswordData(
    val email: String = "",
    val verificationCode: String = "",
    val password: String = "",
    val confirmPassword: String = ""
) {
}