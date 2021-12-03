package com.example.my_poky.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_poky.data.models.MyNote
import com.example.my_poky.data.repo.NoteRepo
import com.example.my_poky.util.AppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    var repo:NoteRepo
):ViewModel() {
    val _allNote=MutableStateFlow<List<MyNote>>(emptyList())
    val allNote:StateFlow<List<MyNote>> get() = _allNote

    val searchAppbarState = mutableStateOf<AppBarState>(AppBarState.CLOSE)
    val textSearchField= mutableStateOf<String>("")

    fun getAllNote(){
        viewModelScope.launch {
            repo.getAllNote.collect {
                _allNote.value=it
            }
        }
    }
}