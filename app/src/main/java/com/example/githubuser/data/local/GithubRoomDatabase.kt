package com.example.githubuser.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubuser.data.model.UserResponse

@Database(entities = [UserResponse.Item::class], version = 1, exportSchema = false)
abstract class GithubRoomDatabase : RoomDatabase() {
    abstract fun githubDao(): GithubDao
}