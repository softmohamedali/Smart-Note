package com.example.my_poky.ui.screens.listscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_poky.data.models.MyNote
import com.example.my_poky.data.models.PriorityNote

@Composable
fun ListContent(){

}

@Composable
fun TaskItem(
    myNote:MyNote,
    navigateToTaskScreen:(taskid:Int) -> Unit
){
    Surface (
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RectangleShape,
        elevation = 10.dp
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),

        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier=Modifier.weight(9f),
                    text = "sdgbd",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Box(modifier=Modifier.weight(1f),
                contentAlignment = CenterEnd) {
                    Surface(
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp),
                        color = Color.Blue,
                        shape = CircleShape,
                    ) {

                    }
                }
            }
            Text(text = "sdbdddddddddd")
        }
    }
}


@Preview
@Composable
fun Pevirew()
{
    TaskItem(MyNote(1,"","",PriorityNote.NONE),{

    })
}