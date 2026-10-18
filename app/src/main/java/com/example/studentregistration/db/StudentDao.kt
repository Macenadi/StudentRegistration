
package com.example.studentregistration.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    suspend fun insertStudent(student: Student): Long

    @Query("SELECT * FROM students WHERE id = :studentId")
    suspend fun getStudentById(studentId: Int): Student?

    @Query("SELECT * FROM students WHERE name like :studentName")
    suspend fun getStudentsByName(studentName: String): List<Student>

}
