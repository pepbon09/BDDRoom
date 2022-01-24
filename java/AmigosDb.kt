package com.example.basededatossql

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MisAmigos::class],
    version = 1
)
abstract class AmigosDb : RoomDatabase() {
    abstract fun misAmigosDao(): MisAmigosDao
}