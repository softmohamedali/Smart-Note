package com.example.my_poky.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.my_poky.data.models.PriorityNote
import com.example.my_poky.ui.theme.toolBarContent

@Composable
fun PriorityItem(priorityNote: PriorityNote)
{
    Row (
        verticalAlignment = Alignment.CenterVertically
            ){
        Canvas(modifier = Modifier
            .size(25.dp)
            .padding(end = 12.dp)){
            drawCircle(priorityNote.mycolor)
        }
        Text(text = priorityNote.name,color = MaterialTheme.colors.onSurface,
        )
    }
}

@Composable
@Preview
fun PrioritfyItem()
{
    PriorityItem(PriorityNote.HIGH)
}