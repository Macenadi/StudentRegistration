
package com.example.studentregistration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentregistration.ui.theme.Home
import com.example.studentregistration.ui.theme.AddStudent
import com.example.studentregistration.ui.theme.FindStudent
import com.example.studentregistration.ui.theme.StudentRegistrationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            StudentRegistrationTheme {

                val navCont = rememberNavController()

                NavHost(
                    navController = navCont,
                    startDestination = "Home"
                ) {

                    composable(route = "Home") {
                        Home(navCont)
                    }

                    composable(route = "AddStudent") {
                        AddStudent(navCont)
                    }

                    composable(route = "FindStudent") {
                        FindStudent(navCont)
                    }
                }
            }
        }
    }
}
