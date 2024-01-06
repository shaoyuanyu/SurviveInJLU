package com.yusy.surviveinjlu.ui.pages.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yusy.surviveinjlu.ui.AppViewModelProvider

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    HomeBody()
}

@Composable
fun HomeBody() {
    Text("Home")
}