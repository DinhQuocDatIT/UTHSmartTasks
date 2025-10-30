package com.example.uthsmarttasks.Auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen() {
    val user = FirebaseAuth.getInstance().currentUser
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        AsyncImage(model = user?.photoUrl, contentDescription = null)
        Text("Tên: ${user?.displayName}")
        Text("Email: ${user?.email}")
    }
}