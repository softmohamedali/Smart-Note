package com.example.my_poky.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.my_poky.util.Action
import com.example.my_poky.util.Constants

fun NavGraphBuilder.taskComposible(
    navigateToListScreen:(Action)->Unit
){
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(Constants.NAME_TASK_ARGUMENT){
            type= NavType.IntType
        })
    ){

    }
}