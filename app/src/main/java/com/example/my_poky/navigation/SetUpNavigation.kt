package com.example.my_poky.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.my_poky.navigation.destination.listComposible
import com.example.my_poky.navigation.destination.taskComposible
import com.example.my_poky.ui.viewmodel.SharedViewModel
import com.example.my_poky.util.Constants

@Composable
fun setUpNavigation(
    navController: NavHostController,
    sharedViewModel:SharedViewModel
){
    val screen= remember (navController){
        Screens(navController)
    }

    NavHost(
        navController = navController,
        startDestination = Constants.lIST_SCREEN
    ){
        listComposible(
            screen.task,
            sharedViewModel=sharedViewModel
        )
        taskComposible(screen.list)
    }
}