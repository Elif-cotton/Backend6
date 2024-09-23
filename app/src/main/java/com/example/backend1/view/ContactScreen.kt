package com.example.backend1.view


import androidx.compose.material3.*
import androidx.compose.runtime.Composable

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.backend1.viewModel.ContactViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen() {
    val viewModel: ContactViewModel = viewModel()

}