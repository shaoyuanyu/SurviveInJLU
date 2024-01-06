package com.yusy.surviveinjlu.data.course.tables

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.LocalTime

@Entity(tableName = "Semesters")
data class Semester(
    @PrimaryKey(autoGenerate = false)
    val semesterIndex: Int, // 学期数索引

    val weekNum: Int, // 周数
    val semesterPeriod: Pair<LocalDateTime, LocalDateTime>, // 学期开始/结束时间<年月日>
    val dailySessionNum: Triple<Int, Int, Int>, // 每天课程节数(早/中/晚)
    val dailyTimeTable: List<Pair<LocalTime, LocalTime>>, // 每天时间表
    val whetherShowWeekend: Boolean = true, // 是否显示周末
    val isMondayFirst: Boolean = true, // 是否以周一开始
    val whetherShowCoursesOfOtherWeeks: Boolean = true, // 是否显示非本周课程
)
