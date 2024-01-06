package com.yusy.surviveinjlu.data

import android.content.Context
import com.yusy.surviveinjlu.data.course.CourseDatabase
import com.yusy.surviveinjlu.data.course.CoursesOfflineRepository
import com.yusy.surviveinjlu.data.course.CoursesRepository

interface AppContainer {
    val coursesRepository: CoursesRepository
}

class AppDataContainer(private val context: Context): AppContainer {
    override val coursesRepository: CoursesRepository by lazy {
        CoursesOfflineRepository(
            courseDao = CourseDatabase.getDatabase(context).courseDao(),
            semesterDao = CourseDatabase.getDatabase(context).semesterDao()
        )
    }
}