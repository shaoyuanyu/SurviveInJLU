package com.yusy.surviveinjlu.data.course

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yusy.surviveinjlu.data.course.tables.Course
import com.yusy.surviveinjlu.data.course.tables.CourseDao
import com.yusy.surviveinjlu.data.course.tables.Semester
import com.yusy.surviveinjlu.data.course.tables.SemesterDao

@Database(entities = [Course::class, Semester::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class CourseDatabase: RoomDatabase() {
    abstract fun courseDao(): CourseDao

    abstract fun semesterDao(): SemesterDao

    companion object {
        @Volatile
        private var Instance: CourseDatabase? = null

        fun getDatabase(context: Context): CourseDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, CourseDatabase::class.java, "course_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}