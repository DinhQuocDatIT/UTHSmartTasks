package com.example.uthsmarttasks.Auth

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.uthsmarttasks.components.ButtonCustom

import com.google.firebase.auth.FirebaseAuth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip

import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.uthsmarttasks.components.ButtonReturn
import com.example.uthsmarttasks.ui.theme.colorCustom
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Camera
import compose.icons.fontawesomeicons.solid.Image

@Composable
fun ProfileScreen(navController: NavController) {

    val user = FirebaseAuth.getInstance().currentUser

    // State để lưu dữ liệu input
    var nameUser by remember { mutableStateOf(user?.displayName ?: "") }
    var emailUser by remember { mutableStateOf(user?.email ?: "") }
    var dateOfBirth by remember { mutableStateOf("") }
     val  photoUrl = user?.photoUrl
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp ,40.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            ButtonReturn { navController.popBackStack()
            }
            Text(text = "Profile" , color = colorCustom.primary, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Row {  }
        }
    if(photoUrl!=null){
        Box(
            modifier = Modifier.size(120.dp)
        ){

            AsyncImage(
                model = photoUrl,
                contentDescription = "Ảnh đại diện",
                modifier = Modifier.size(120.dp).padding(10.dp).clip(CircleShape).border(width = 1.dp,
                    colorCustom.primary,CircleShape)
            )
            IconButton(onClick = {},modifier = Modifier.align(Alignment.BottomEnd).size(24.dp)) {
                Icon(
                    imageVector = FontAwesomeIcons.Solid.Camera,
                    contentDescription = "Thay ảnh",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

    }
        Column(modifier = Modifier.fillMaxWidth()) {
            // Name
            Text("Name", fontWeight = FontWeight.Bold, color = Color.Black)
            OutlinedTextField(
                value = nameUser,
                onValueChange = { nameUser = it },
                placeholder = { Text("Enter your name") },
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)).border(width = 1.dp, color = Color(0xFFC9C9C9)),
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))


            Text("Email", fontWeight = FontWeight.Bold, color = Color.Black)
            OutlinedTextField(
                value = emailUser,
                onValueChange = { emailUser = it },
                placeholder = { Text("Enter your email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)).border(width = 1.dp, color = Color(0xFFC9C9C9)),
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))


            Text("Date of Birth", fontWeight = FontWeight.Bold, color = Color.Black)
            OutlinedTextField(
                value = dateOfBirth,
                onValueChange = { dateOfBirth = it },
                placeholder = { Text("DD/MM/YYYY") },
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)).border(width = 1.dp, color = Color(0xFFC9C9C9)),
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))


        // Nút quay về
        ButtonCustom("Quay về") {
            navController.popBackStack()
        }
    }
}
