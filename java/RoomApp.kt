package com.example.basededatossql

import android.app.Application
import androidx.room.Room

class RoomApp : Application() {
    companion object {
        lateinit var db: AmigosDb
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, AmigosDb::class.java, "amigos").build()
    }
}