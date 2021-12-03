package com.example.my_poky.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.my_poky.util.Constants

@Entity(tableName = Constants.TABLE_NAME)
data class MyNote (
     @PrimaryKey(autoGenerate = true)
     var id:Int=0,
     var title:String,
     var description:String,
     var priority: PriorityNote
     )
 {

 }