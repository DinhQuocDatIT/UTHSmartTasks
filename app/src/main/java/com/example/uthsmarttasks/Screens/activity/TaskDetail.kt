package com.example.uthsmarttasks.Screens.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.uthsmarttasks.components.ButtonReturn
import com.example.uthsmarttasks.data.viewModel.TaskDetailViewModel
import com.example.uthsmarttasks.ui.theme.colorCustom
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Certificate
import compose.icons.fontawesomeicons.solid.EyeSlash
import compose.icons.fontawesomeicons.solid.RemoveFormat
import compose.icons.fontawesomeicons.solid.Trash

@Composable
fun TaskDetail(
    taskId: Int,
    navController: NavController,
    viewModel: TaskDetailViewModel = viewModel()
) {
    val task by viewModel.task.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    // Gọi API khi mở màn
    LaunchedEffect(taskId) {
        viewModel.fetchTaskDetail(taskId)
    }
    val deleteSuccess by viewModel.deleteSuccess.collectAsState()

    LaunchedEffect(deleteSuccess) {
        if (deleteSuccess) {
            // Quay về danh sách sau khi xoá thành công
            navController.popBackStack()
        }
    }
    when {
        isLoading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }

        error != null -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Lỗi: $error")
        }

        task != null -> {
            val t = task!!

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                // --- Thanh header ---
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ButtonReturn(onClick = { navController.popBackStack() })
                    Text("Detail", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = colorCustom.primary)
                    IconButton(onClick = {
                        viewModel.deleteTask(taskId)
                    }) {

                        Icon(
                            imageVector = FontAwesomeIcons.Solid.Trash,
                            contentDescription = "Xóa",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                // --- Ảnh mô tả ---


                // --- Thông tin chính ---
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(t.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(t.description)
                }

                // --- 3 thông tin nhỏ ---
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFFFEBF1))
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    InfoItem(label = "Category", value = t.category)
                    InfoItem(label = "Priority", value = t.priority)
                    InfoItem(label = "Status", value = t.status)
                }

                // --- Subtasks ---
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text("Subtasks", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 10.dp))
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        items(t.subtasks) { sub ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFFE5E5E5))
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = (if (sub.isCompleted) " " else " ") + sub.title,
                                    fontWeight = if (sub.isCompleted) FontWeight.Medium else FontWeight.Normal
                                )
                            }
                        }
                    }
                }

                // --- Attachments ---
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text("Attachments", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 10.dp))
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        items(t.attachments) { attach ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFFE5E5E5))
                                    .padding(10.dp)
                                    .clickable { /* mở link */ },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(" ${attach.fileName}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun InfoItem(label: String, value: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.Certificate,
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        Column {
            Text(label)
            Text(value, fontWeight = FontWeight.Bold)
        }
    }
}
