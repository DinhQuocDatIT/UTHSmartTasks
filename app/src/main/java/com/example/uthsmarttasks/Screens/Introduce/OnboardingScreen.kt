package com.example.uthsmarttasks.Screens.Introduce

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uthsmarttasks.Module.Introduce
import com.example.uthsmarttasks.R
import com.example.uthsmarttasks.ui.theme.colorCustom
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(navController: NavController) {

    val pages = remember {
        listOf(
            Introduce("Easy Time Management", "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first ", R.drawable.introduce1),
            Introduce("Increase Work Effectiveness", "Time management and the determination of more important tasks will give your job statistics better and always improve", R.drawable.introduce2),
            Introduce("Reminder Notification", "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set", R.drawable.introduce3)
        )
    }

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val coroutineScope = rememberCoroutineScope()

    var textButton by remember { mutableStateOf("Next") }
    LaunchedEffect(pagerState.currentPage) {
        textButton = if (pagerState.currentPage == pages.lastIndex) "Get started" else "Next"
    }
    Column(modifier = Modifier.fillMaxSize().background(color = Color.White).padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
        Row(modifier = Modifier.fillMaxWidth().padding(top=50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            PageIndicator(currentPage = pagerState.currentPage, pageCount = pages.size)
            TextButton(onClick = {
                // Ví dụ: chuyển sang màn hình chính
                // navController.navigate("home")
            }) {
                Text("Skip", color = colorCustom.primary, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
Column(modifier = Modifier.fillMaxWidth()) {
    HorizontalPager(state = pagerState) { page ->
        OnboardingPageItem(page = pages[page])
    }
}

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(12.dp),
    verticalAlignment = Alignment.CenterVertically
){
    if (pagerState.currentPage >0) {
        IconButton(onClick = {
            coroutineScope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage - 1)
            }
        }, modifier = Modifier.background(color = colorCustom.primary,shape = CircleShape)) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Quay về",
                tint = Color.White
            )
        }
    }

    Button(onClick = {
        coroutineScope.launch {
            if (pagerState.currentPage < pages.size - 1) {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            } else {
                // Nếu đang ở trang cuối → quay lại trang trước
                pagerState.animateScrollToPage(pagerState.currentPage - 1)
            }
        }
    },
        modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(30.dp)).background(color = colorCustom.primary).padding(2.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorCustom.primary
        )) {
        Text((textButton), fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}


    }
}
