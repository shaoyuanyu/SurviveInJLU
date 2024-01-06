package com.yusy.surviveinjlu.data.course

import com.yusy.surviveinjlu.data.course.tables.Course
import com.yusy.surviveinjlu.data.course.tables.CourseDao
import com.yusy.surviveinjlu.data.course.tables.Semester
import com.yusy.surviveinjlu.data.course.tables.SemesterDao
import kotlinx.coroutines.flow.Flow

class CoursesOfflineRepository(
    private val courseDao: CourseDao,
    private val semesterDao: SemesterDao
): CoursesRepository {
    // Course
    override suspend fun insertCourse(course: Course) = courseDao.insert(course)
    override suspend fun updateCourse(course: Course) = courseDao.update(course)
    override suspend fun deleteCourse(course: Course) = courseDao.delete(course)
    override fun getAllCourses(): Flow<List<Course>> = courseDao.getAllCourses()
    override fun getCoursesById(id: Int): Flow<List<Course>> = courseDao.getCoursesById(id)
    override fun getCoursesBySemester(semesterIndex: Int): Flow<List<Course>> = courseDao.getCoursesBySemester(semesterIndex)
    override fun getCoursesByName(nameKeyWord: String): Flow<List<Course>> = courseDao.getCoursesByName(nameKeyWord)

    // Semester
    override suspend fun insertSemester(semester: Semester) = semesterDao.insert(semester)
    override suspend fun updateSemester(semester: Semester) = semesterDao.update(semester)
    override suspend fun deleteSemester(semester: Semester) = semesterDao.delete(semester)
    override fun getAllSemesters(): Flow<List<Semester>> = semesterDao.getAllSemesters()
    override fun getSemesterByIndex(index: Int): Flow<Semester> = semesterDao.getSemesterByIndex(index)
}