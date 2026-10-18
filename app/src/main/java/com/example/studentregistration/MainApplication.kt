
package com.example.studentregistration

import android.app.Application
import androidx.room.Room
import com.example.studentregistration.db.StudentDatabase

class MainApplication : Application() {

    lateinit var database: StudentDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            StudentDatabase::class.java,
            "student_database"
        ).build()
    }
}
