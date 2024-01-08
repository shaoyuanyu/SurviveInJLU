package com.yusy.surviveinjlu.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.yusy.surviveinjlu.MainApplication
import com.yusy.surviveinjlu.ui.pages.home.HomeViewModel
import com.yusy.surviveinjlu.ui.pages.timetable.TimeTableViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Home ViewModel
        initializer { HomeViewModel(getMainApplication().container.coursesRepository) }
        // TimeTable ViewModel
        initializer { TimeTableViewModel(getMainApplication().container.coursesRepository) }
    }
}

fun CreationExtras.getMainApplication(): MainApplication =
    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MainApplication