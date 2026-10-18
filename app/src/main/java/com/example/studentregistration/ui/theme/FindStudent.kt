
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
import com.example.studentregistration.view.StudentViewModel

@Composable
fun FindStudent(
    navController: NavController,
    studentViewModel: StudentViewModel
) {

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

            val validId = studentId.toIntOrNull()

            when {
                studentId.isBlank() -> {
                    message = "Please enter a Student ID"
                }

                validId == null || validId <= 0 -> {
                    message = "Please enter a valid Student ID"
                }

                else -> {
                    message = "Searching..."

                    studentViewModel.findStudent(validId) { student ->

                        message = if (student != null) {
                            "Student Found!\n" +
                                    "ID: ${student.id}\n" +
                                    "Name: ${student.name}\n" +
                                    "Course: ${student.course}\n" +
                                    "Year: ${student.year}"
                        } else {
                            "Student not found"
                        }
                    }
                }
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
