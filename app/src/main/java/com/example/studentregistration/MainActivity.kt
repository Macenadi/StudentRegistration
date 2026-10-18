
package com.example.studentregistration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentregistration.ui.theme.StudentRegistrationTheme
import com.example.studentregistration.ui.theme.Home
import com.example.studentregistration.ui.theme.AddStudent
import com.example.studentregistration.ui.theme.FindStudent
import com.example.studentregistration.view.StudentViewModel
import com.example.studentregistration.view.StudentViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val application = application as MainApplication
        val studentDao = application.database.studentDao()
        val factory = StudentViewModelFactory(studentDao)

        val studentViewModel = ViewModelProvider(
            this,
            factory
        )[StudentViewModel::class.java]

        setContent {
            StudentRegistrationTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "Home"
                ) {

                    composable("Home") {
                        Home(navController)
                    }

                    composable("AddStudent") {
                        AddStudent(navController, studentViewModel)
                    }

                    composable("FindStudent") {
                        FindStudent(navController, studentViewModel)
                    }
                }
            }
        }
    }
}
