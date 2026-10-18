
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
fun AddStudent(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            20.dp,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Student Registration")

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Student Name") }
        )

        OutlinedTextField(
            value = course,
            onValueChange = { course = it },
            label = { Text("Course") }
        )

        OutlinedTextField(
            value = year,
            onValueChange = { year = it },
            label = { Text("Year (1-4)") }
        )

        Button(onClick = {
            val validYear = year.toIntOrNull()

            message = when {
                name.isBlank() || course.isBlank() ->
                    "Please fill in all fields"

                validYear == null || validYear !in 1..4 ->
                    "Year must be between 1 and 4"

                else ->
                    "Valid details. Database not connected yet."
            }
        }) {
            Text(text = "Save Student")
        }

        Text(text = message)

        Button(onClick = {
            navController.navigate("Home")
        }) {
            Text(text = "Back to Home")
        }

        Button(onClick = {
            navController.navigate("FindStudent")
        }) {
            Text(text = "Find Student")
        }
    }
}
