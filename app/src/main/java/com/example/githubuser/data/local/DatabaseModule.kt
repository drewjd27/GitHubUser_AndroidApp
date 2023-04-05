package com.example.githubuser.data.local

import android.content.Context
import androidx.room.Room

class DatabaseModule(private val context: Context) {
    private val db = Room.databaseBuilder(context, GithubRoomDatabase::class.java, "user_github.db")
        .allowMainThreadQueries()
        .build()

    val githubDao = db.githubDao()
}