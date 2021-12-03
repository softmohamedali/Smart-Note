package com.example.my_poky.ui.screens.listscreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.my_poky.data.models.PriorityNote
import com.example.my_poky.ui.theme.toolBarBackGround
import com.example.my_poky.ui.theme.toolBarContent
import com.example.my_poky.R
import com.example.my_poky.component.PriorityItem
import com.example.my_poky.ui.viewmodel.SharedViewModel
import com.example.my_poky.util.AppBarState
import com.example.my_poky.util.TrailingIconState


@Composable
fun ListAppBar(
    sharedViewModel: SharedViewModel,
    appBarState: AppBarState,
    textSearshField:String
){
    when(appBarState)
    {
        AppBarState.CLOSE ->{
            DefaultAppBar(
                onclickSearch = {
                    sharedViewModel.searchAppbarState.value=AppBarState.OPEN
                },
                onclickDelte = {},
                onclickSort = {}
            )
        }
        else ->{
            SearchAppbar(
                text = textSearshField,
                onTextChanged ={
                    sharedViewModel.textSearchField.value=it
                } ,
                onSearchClicked = {},
                onCloseClicked = {
                    sharedViewModel.searchAppbarState.value=AppBarState.CLOSE
                    sharedViewModel.textSearchField.value=""
                }
            )
        }
    }
}
@Composable
fun DefaultAppBar(
    onclickSearch: () -> Unit,
    onclickSort: (PriorityNote) -> Unit,
    onclickDelte: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "tex", color = MaterialTheme.colors.toolBarContent) },
        backgroundColor = MaterialTheme.colors.toolBarBackGround,
        actions = {
            SearchIconAction(onclickSearch)
            FilterIconAction(onclickSort)
            DelteIconAction(onclickDelte)
        }
    )
}

@Composable
fun DelteIconAction(onclick: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = {expanded=true}
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = "",
            tint = MaterialTheme.colors.toolBarContent
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onclick()
                }) {
                Text(text = "Delte All",Modifier.padding(10.dp))
            }
        }

    }
}

@Composable
fun FilterIconAction(onclick: (PriorityNote) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = {expanded=true}
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = "",
            tint = MaterialTheme.colors.toolBarContent
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onclick(PriorityNote.HIGH)
                }) {
                PriorityItem(priorityNote = PriorityNote.HIGH)
            }
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onclick(PriorityNote.NORMAL)
                }) {
                PriorityItem(priorityNote = PriorityNote.NORMAL)
            }
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onclick(PriorityNote.NONE)
                }) {
                PriorityItem(priorityNote = PriorityNote.NONE)
            }
        }

    }
}

@Composable
fun SearchIconAction(onclick: () -> Unit) {
    IconButton(
        onClick = onclick
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "",
            tint = MaterialTheme.colors.toolBarContent
        )
    }
}

@Composable
fun SearchAppbar(
    text:String,
    onTextChanged:(text:String)->Unit,
    onSearchClicked:(text:String)->Unit,
    onCloseClicked:()->Unit
){
    var trailingAppbarState by remember {
        mutableStateOf(TrailingIconState.READY_TO_CLOSE)
    }
    Surface(
        Modifier
            .fillMaxWidth()
            .height(56.dp),
        color = MaterialTheme.colors.toolBarBackGround
    ) {
        TextField(
            value = text,
            onValueChange = {
                onTextChanged(it)
            } ,
            leadingIcon = {
                IconButton(
                    onClick = {onSearchClicked(text) },
                ) {
                    Icon(imageVector =Icons.Default.Search, contentDescription ="search",tint =
                    MaterialTheme.colors.toolBarContent)
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        when(trailingAppbarState)
                        {
                            TrailingIconState.READY_TO_CLOSE ->{
                                if (text.isNotEmpty())
                                {
                                    onTextChanged("")
                                }else
                                {
                                    onCloseClicked()
                                    trailingAppbarState=TrailingIconState.READY_TO_DELTE
                                }
                            }
                            TrailingIconState.READY_TO_DELTE ->{
                                onTextChanged("")
                                trailingAppbarState=TrailingIconState.READY_TO_DELTE
                            }
                        }
                    }
                ) {
                    Icon(imageVector =Icons.Default.Close, contentDescription ="search" ,tint =
                    MaterialTheme.colors.toolBarContent)
                }
            },
            placeholder = {
                Text(text = "Search",modifier = Modifier.alpha(ContentAlpha.medium))
            }
        )
    }
}