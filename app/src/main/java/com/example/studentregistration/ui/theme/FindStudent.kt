
package com.example.studentregistration.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FindStudent(navController: NavController) {

    var studentId by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            20.dp,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Find Student")

        OutlinedTextField(
            value = studentId,
            onValueChange = { studentId = it },
            label = { Text("Student ID") },
            singleLine = true
        )

        Button(onClick = {
            message = if (studentId.isBlank()) {
                "Please enter a Student ID"
            } else {
                "Database search not implemented yet"
            }
        }) {
            Text(text = "Search Student")
        }

        Text(text = message)

        Button(onClick = {
            navController.navigate("Home")
        }) {
            Text(text = "Back to Home")
        }

        Button(onClick = {
            navController.navigate("AddStudent")
        }) {
            Text(text = "Add Student")
        }
    }
}
