package com.yusy.surviveinjlu.data.course.tables

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.DayOfWeek
import java.time.LocalTime

@Entity(tableName = "Courses")
data class Course(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // 主键

    // 课程基本信息
    val courseCode: String, // 课程代码
    val courseName: String, // 课程名
    val courseSemesterIndex: Int, // 课程所在学期
    val courseWeekPeriod: List<Int>, // 课程所在周
    val isFinalExamRequired: Boolean = true, // 是否需要期末考试

    val colorInTable: String = "#FFFFFF", // 在课程表中显示的颜色

    val courseArrangementList: List<CourseArrangement>,
)

/**
 * 一天的课程安排
 */
data class CourseArrangement(
    val dayOfWeek: DayOfWeek, // 周几
    val courseWeekList: List<Int>, // 哪些周
    val sessionList: List<Int>, // 哪几节
    val isRegularSession: Boolean = true, // 是否是规则的分节(遵循课程表划分的时间安排)
    val irregularTimePeriod: List<Pair<LocalTime, LocalTime>>? = null, // 对于不规则分节的课程，自定义时间
    val courseLocation: String, // 上课地点
    val courseInstructor: String, // 主讲教师
)