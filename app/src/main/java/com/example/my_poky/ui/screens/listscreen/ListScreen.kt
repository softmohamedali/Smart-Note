package com.example.my_poky.ui.screens

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.example.my_poky.ui.screens.listscreen.ListAppBar
import com.example.my_poky.ui.viewmodel.SharedViewModel

@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    val searchAppBarState by sharedViewModel.searchAppbarState
    val textSearchField by sharedViewModel.textSearchField
    Scaffold(
        content = {},
        floatingActionButton = { ListFab(navigateToTaskScreen) },
        topBar = {
            ListAppBar(
               sharedViewModel = sharedViewModel,
               textSearshField = textSearchField,
               appBarState = searchAppBarState
            )
        }
    )
}

@Composable
fun ListFab(onFabClick: (Int) -> Unit) {
    FloatingActionButton(onClick = { onFabClick(-1) }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "", tint = Color.White)
    }
}

