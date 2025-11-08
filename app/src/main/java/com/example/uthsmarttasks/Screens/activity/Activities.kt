package com.example.uthsmarttasks.Screens.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.uthsmarttasks.components.ButtonReturn


import com.example.uthsmarttasks.data.model.Task
import com.example.uthsmarttasks.data.viewModel.TaskViewModel
import com.example.uthsmarttasks.ui.theme.UthsmarttasksTheme
import com.example.uthsmarttasks.ui.theme.colorCustom
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Certificate
import compose.icons.fontawesomeicons.solid.Trash


@Composable
fun Activities(navController: NavController,
               viewModel: TaskViewModel = viewModel()) {
    val tasks by viewModel.tasks.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    when {
        isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        error != null -> {
            Box(
                modifier = Modifier.fillMaxSize(),

            ) {
                Column(modifier = Modifier.fillMaxWidth().padding(10.dp,50.dp,10.dp,10.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {
                        ButtonReturn(onClick = { navController.popBackStack() })
                        Text("List", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = colorCustom.primary)
                    Text("")
                    }
                    Column(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)).background(color = Color(
                        0xFFE1E1E1
                    )
                    ).padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(15.dp)) {
                        Icon(
                            imageVector = FontAwesomeIcons.Solid.Certificate,
                            contentDescription = "Trong",
                            modifier = Modifier.size(100.dp)

                        )
                        Text("No Tasks Yet!", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text("Stay productive-add sometime to do")
                    }

                }

            }
        }

        else -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(10.dp,50.dp,10.dp,10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(tasks) { task -> if(task.status =="In Progress"){
                    TaskCard(task, navController,Color(0xFFFFEBF1))
                } else if(task.status =="Completed"){
                    TaskCard(task, navController,Color(0xFFF0FCCD))
                }
                    else{
                    TaskCard(task, navController,Color(0xFFB4FFC3))
                }


                }
            }
        }
    }
}

@Composable
fun TaskCard(task: Task,navController: NavController,x: Color) {
    var isCheced by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(x)
            .clickable {

                navController.navigate("taskDetail/${task.id}")
            }
            .padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = x),

    ) {
        Column(modifier = Modifier.padding(10.dp)) {

            // Hàng 1: Title + Description
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Checkbox(
                    checked = isCheced,
                    onCheckedChange = {value -> isCheced = value}
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(task.title, fontWeight = FontWeight.Bold)
                    Text(task.description)
                }
            }

            // Hàng 2: Status + Due Date
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Status: ${task.status}", fontWeight = FontWeight.Bold)
                Text(task.dueDate.take(10)) // chỉ lấy yyyy-MM-dd
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ListActivityPreview() {
//    UthsmarttasksTheme {
//        // giả lập 1 task để preview
//        TaskCard(
//            task = Task(
//                id = 1,
//                title = "Complete Android Project",
//                description = "Finish the UI, integrate API, and write documentation",
//                status = "In Progress",
//                priority = "High",
//                category = "Work",
//                dueDate = "2024-03-26T09:00:00Z",
//                createdAt = "",
//                updatedAt = "",
//                subtasks = emptyList(),
//                attachments = emptyList(),
//                reminders = emptyList()
//            )
//        )
//    }
//}
