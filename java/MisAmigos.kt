package com.example.basededatossql

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "amigos")
data class MisAmigos(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "identificador")
    var id:Int = 0,
    var nombre:String,
    var email:String
)
