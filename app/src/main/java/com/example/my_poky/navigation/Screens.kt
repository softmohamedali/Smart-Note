package com.example.my_poky.navigation

import androidx.navigation.NavHostController
import com.example.my_poky.util.Action
import com.example.my_poky.util.Constants.lIST_SCREEN

class Screens(var navController: NavHostController) {
    val list:(Action) -> Unit ={action ->
        navController.navigate("list/${action.name}"){
            popUpTo(lIST_SCREEN)
        }
    }
    val task:(Int)->Unit={id->
        navController.navigate("task/$id")
    }
}