package com.example.my_poky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.my_poky.navigation.setUpNavigation
import com.example.my_poky.ui.theme.My_pokyTheme
import com.example.my_poky.ui.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navCntroller:NavHostController
    private val sharedViewModel by viewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            My_pokyTheme {
                navCntroller= rememberNavController()
                setUpNavigation(
                    navController = navCntroller,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}

