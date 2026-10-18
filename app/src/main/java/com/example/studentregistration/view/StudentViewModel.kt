
package com.example.studentregistration.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentregistration.db.Student
import com.example.studentregistration.db.StudentDao
import kotlinx.coroutines.launch

class StudentViewModel(
    private val studentDao: StudentDao
) : ViewModel() {

    fun addStudent(
        name: String,
        course: String,
        year: Int
    ) {
        viewModelScope.launch {
            val student = Student(
                name = name,
                course = course,
                year = year
            )

            studentDao.insertStudent(student)
        }
    }

    fun findStudent(
        studentId: Int,
        onResult: (Student?) -> Unit
    ) {
        viewModelScope.launch {
            val student = studentDao.getStudentById(studentId)
            onResult(student)
        }
    }
}
