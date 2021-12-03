package com.example.my_poky.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFF04B59)
val Purple500 = Color(0xFF00AEFF)
val Purple700 = Color(0xFF007BFD)
val Teal200 = Color(0xFF0088FF)

val HighPriority= Color(0xFFFD0000)
val NonePriority= Color(0xFFFFFFFF)
val MediunPriority= Color(0xFF0026E6)
val NormalPriority= Color(0xFF23B32A)

val black= Color(0xFF000000)
val white= Color(0xFFFFFFFF)
val blue= Color(0xFF007BFD)
val darkBlue= Color(0xFF101922)

val Colors.toolBarContent
    @Composable
    get() = if (isLight)
        white else white

val Colors.toolBarBackGround
    @Composable
    get() = if (isLight) blue else darkBlue










