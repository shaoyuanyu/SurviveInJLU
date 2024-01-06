package com.yusy.surviveinjlu.data.course

import com.yusy.surviveinjlu.data.course.tables.Course
import com.yusy.surviveinjlu.data.course.tables.Semester
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {
    // Course
    suspend fun insertCourse(course: Course)
    suspend fun updateCourse(course: Course)
    suspend fun deleteCourse(course: Course)
    fun getAllCourses(): Flow<List<Course>>
    fun getCoursesById(id: Int): Flow<List<Course>>
    fun getCoursesBySemester(semesterIndex: Int): Flow<List<Course>>
    fun getCoursesByName(nameKeyWord: String): Flow<List<Course>>

    // Semester
    suspend fun insertSemester(semester: Semester)
    suspend fun updateSemester(semester: Semester)
    suspend fun deleteSemester(semester: Semester)
    fun getAllSemesters(): Flow<List<Semester>>
    fun getSemesterByIndex(index: Int): Flow<Semester>
}