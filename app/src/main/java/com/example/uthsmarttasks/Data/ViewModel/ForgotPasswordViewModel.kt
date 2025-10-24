package com.example.uthsmarttasks.Data.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.uthsmarttasks.Data.Module.ForgotPasswordData

class  ForgotPasswordViewModel: ViewModel(){

    var forgotPassword = mutableStateOf(ForgotPasswordData())

}
