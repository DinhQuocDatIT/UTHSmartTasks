package com.example.uthsmarttasks.Data.Module

data class ForgotPasswordData(
    val email: String = "",
    val verificationCode: String = "",
    val password: String = "",
    val confirmPassword: String = ""
) {
}