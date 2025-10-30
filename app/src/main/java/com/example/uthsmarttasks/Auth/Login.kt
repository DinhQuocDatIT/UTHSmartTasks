package com.example.uthsmarttasks.Auth

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uthsmarttasks.R
import com.example.uthsmarttasks.ui.theme.UthsmarttasksTheme
import com.example.uthsmarttasks.ui.theme.colorCustom

@Composable
fun Login(onLoginSuccess: () -> Unit,
          googleSignInManager: GoogleSignInManager,navController: NavController){
    val activity = LocalActivity.current ?: return // ✅ hoặc getActivity() nếu bạn tự viết helper

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                googleSignInManager.handleSignInResult(result.data) { success, name ->
                    if (success) {
                        Toast.makeText(activity, "Xin chào $name!", Toast.LENGTH_SHORT).show()
                        onLoginSuccess()
                    } else {
                        Toast.makeText(activity, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    )
    Column(modifier = Modifier.fillMaxSize().background(color = Color.White).padding(top = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(R.drawable.logouth),
                contentDescription = "Logo uth",
                modifier = Modifier.width(200.dp).height(200.dp)
            )
            Text(text = "SmartTasks", color = colorCustom.primary, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text(text = "A simple and effcient to-do-app",color = colorCustom.primary, fontSize = 12.sp,)

        }
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(text = "Welcome", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text("Ready to explore? Login to get started", color = Color(0xFF737373), fontSize = 16.sp,)
            Button(onClick = {googleSignInManager.signIn(launcher)}, shape = RoundedCornerShape(3.dp), colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF8ED5E3)
            )) {
                Text(text = "Sign in with google",color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
        Text("@dinhquocdat")
    }


}
//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    UthsmarttasksTheme {
//        val navController = rememberNavController()
//        Login(
//            onLoginSuccess = {},
//            googleSignInManager = GoogleSignInManager(Activity()), // 👈 tạo instance thật
//            navController = navController
//        )
//    }
//}