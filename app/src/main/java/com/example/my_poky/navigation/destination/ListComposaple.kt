package com.example.my_poky.navigation.destination

import androidx.compose.material.Scaffold
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.my_poky.ui.screens.ListScreen
import com.example.my_poky.ui.viewmodel.SharedViewModel
import com.example.my_poky.util.Constants

fun NavGraphBuilder.listComposible(
    navigateToTaskScreen:(Int)->Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = Constants.lIST_SCREEN,
        arguments = listOf(navArgument(Constants.NAME_lIST_ARGUMENT){
            type= NavType.StringType
        })
    ){
        ListScreen(
            navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}