
package com.example.studentregistration.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentregistration.db.StudentDao

class StudentViewModelFactory(
    private val studentDao: StudentDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(studentDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
