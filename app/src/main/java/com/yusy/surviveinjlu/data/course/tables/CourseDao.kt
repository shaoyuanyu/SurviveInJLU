package com.yusy.surviveinjlu.data.course.tables

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(course: Course)

    @Update
    suspend fun update(course: Course)

    @Delete
    suspend fun delete(course: Course)

    @Query("SELECT * from Courses ORDER BY (courseSemesterIndex, courseName) ASC")
    fun getAllCourses(): Flow<List<Course>>

    @Query("SELECT * from Courses WHERE id = :id ORDER BY courseName ASC")
    fun getCoursesById(id: Int): Flow<List<Course>>

    @Query("SELECT * from Courses WHERE courseSemesterIndex = :semesterIndex ORDER BY courseName ASC")
    fun getCoursesBySemester(semesterIndex: Int): Flow<List<Course>>

    @Query("SELECT * from Courses WHERE courseName LIKE '%' || :nameKeyWord || '%' ORDER BY courseName ASC")
    fun getCoursesByName(nameKeyWord: String): Flow<List<Course>>
}