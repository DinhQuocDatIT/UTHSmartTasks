package com.example.uthsmarttasks.data.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.uthsmarttasks.data.model.ForgotPasswordData

class  ForgotPasswordViewModel: ViewModel(){

    var forgotPassword = mutableStateOf(ForgotPasswordData())

}
