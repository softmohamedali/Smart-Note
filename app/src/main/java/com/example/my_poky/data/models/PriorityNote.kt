package com.example.my_poky.data.models

import androidx.compose.ui.graphics.Color
import com.example.my_poky.ui.theme.HighPriority
import com.example.my_poky.ui.theme.MediunPriority
import com.example.my_poky.ui.theme.NonePriority
import com.example.my_poky.ui.theme.NormalPriority

enum class PriorityNote(var mycolor:Color) {
    HIGH(mycolor = HighPriority),
    MEDIEUM(mycolor = MediunPriority),
    NORMAL(mycolor = NormalPriority),
    NONE(mycolor = NonePriority),

}