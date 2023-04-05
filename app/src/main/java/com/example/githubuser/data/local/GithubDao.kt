package com.example.githubuser.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.githubuser.data.model.UserResponse

@Dao
interface GithubDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserResponse.Item)

    @Query("SELECT * FROM User")
    fun loadAll(): LiveData<MutableList<UserResponse.Item>>

    @Query("SELECT * FROM User WHERE id LIKE :id LIMIT 1")
    fun findById(id: Int): UserResponse.Item

    @Delete
    fun delete(user: UserResponse.Item)
}