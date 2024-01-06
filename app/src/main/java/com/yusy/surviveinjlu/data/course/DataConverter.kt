package com.yusy.surviveinjlu.data.course

import androidx.compose.ui.graphics.Color
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yusy.surviveinjlu.data.course.tables.CourseArrangement
import java.time.LocalDateTime
import java.time.LocalTime

interface DataConverterInterface {
    // IntList
    fun fromIntList(value: List<Int>): String
    fun toIntList(value: String): List<Int>

    // CourseArrangementList
    fun fromCourseArrangementList(value: List<CourseArrangement>): String
    fun toCourseArrangementList(value: String): List<CourseArrangement>

    // LocalDateTimePair
    fun fromLocalDateTimePair(value: Pair<LocalDateTime, LocalDateTime>): String
    fun toLocalDateTimePair(value: String): Pair<LocalDateTime, LocalDateTime>

    // LocalTimePairList
    fun fromLocalTimePairList(value: List<Pair<LocalTime, LocalTime>>): String
    fun toLocalTimePairList(value: String): List<Pair<LocalTime, LocalTime>>

    // IntTriple
    fun fromIntTriple(value: Triple<Int, Int, Int>): String
    fun toIntTriple(value: String): Triple<Int, Int, Int>

    // Color
    fun fromColor(value: Color): String
    fun toColor(value: String): Color
}

class DataConverter: DataConverterInterface {
    // IntList
    @TypeConverter
    override fun fromIntList(value: List<Int>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    override fun toIntList(value: String): List<Int> {
        val gson = Gson()
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(value, type)
    }

    // CourseArrangementList
    @TypeConverter
    override fun fromCourseArrangementList(value: List<CourseArrangement>): String {
        val gson = Gson()
        val type = object : TypeToken<List<CourseArrangement>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    override fun toCourseArrangementList(value: String): List<CourseArrangement> {
        val gson = Gson()
        val type = object : TypeToken<List<CourseArrangement>>() {}.type
        return gson.fromJson(value, type)
    }

    // LocalDateTimePair
    @TypeConverter
    override fun fromLocalDateTimePair(value: Pair<LocalDateTime, LocalDateTime>): String {
        val gson = Gson()
        val type = object : TypeToken<Pair<LocalDateTime, LocalDateTime>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    override fun toLocalDateTimePair(value: String): Pair<LocalDateTime, LocalDateTime> {
        val gson = Gson()
        val type = object : TypeToken<Pair<LocalDateTime, LocalDateTime>>() {}.type
        return gson.fromJson(value, type)
    }

    // LocalTimePairList
    @TypeConverter
    override fun fromLocalTimePairList(value: List<Pair<LocalTime, LocalTime>>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Pair<LocalTime, LocalTime>>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    override fun toLocalTimePairList(value: String): List<Pair<LocalTime, LocalTime>> {
        val gson = Gson()
        val type = object : TypeToken<List<Pair<LocalTime, LocalTime>>>() {}.type
        return gson.fromJson(value, type)
    }

    // IntTriple
    @TypeConverter
    override fun fromIntTriple(value: Triple<Int, Int, Int>): String {
        val gson = Gson()
        val type = object : TypeToken<Triple<Int, Int, Int>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    override fun toIntTriple(value: String): Triple<Int, Int, Int> {
        val gson = Gson()
        val type = object : TypeToken<Triple<Int, Int, Int>>() {}.type
        return gson.fromJson(value, type)
    }

    // Color
    @TypeConverter
    override fun fromColor(value: Color): String {
        val gson = Gson()
        val type = object : TypeToken<Color>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    override fun toColor(value: String): Color {
        val gson = Gson()
        val type = object : TypeToken<Color>() {}.type
        return gson.fromJson(value, type)
    }
}

//    @TypeConverter
//    fun <T> fromList(value: List<T>): String {
//        val gson = Gson()
//        val type = object : TypeToken<List<T>>() {}.type
//        return gson.toJson(value, type)
//    }
//
//    @TypeConverter
//    fun <T> toList(value: String): List<T> {
//        val gson = Gson()
//        val type = object : TypeToken<List<T>>() {}.type
//        return gson.fromJson(value, type)
//    }