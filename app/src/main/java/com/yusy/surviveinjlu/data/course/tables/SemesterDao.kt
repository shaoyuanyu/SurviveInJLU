package com.yusy.surviveinjlu.data.course.tables

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SemesterDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(semester: Semester)

    @Update
    suspend fun update(semester: Semester)

    @Delete
    suspend fun delete(semester: Semester)

    @Query("SELECT * from Semesters")
    fun getAllSemesters(): Flow<List<Semester>>

    @Query("SELECT * from Semesters WHERE semesterIndex = :index")
    fun getSemesterByIndex(index: Int): Flow<Semester>
}