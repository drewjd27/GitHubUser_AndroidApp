package com.example.githubuser.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class UserResponse(

    @field:SerializedName("total_count")
    val totalCount: Int,

    @field:SerializedName("incomplete_results")
    val incompleteResults: Boolean,

    @field:SerializedName("items")
    val items: MutableList<Item>
) {
    @Parcelize
    @Entity(tableName = "user")
    data class Item(
        @ColumnInfo(name = "login")
        @field:SerializedName("login")
        val login: String,

        @ColumnInfo(name = "url")
        @field:SerializedName("url")
        val url: String,

        @ColumnInfo(name = "avatarUrl")
        @field:SerializedName("avatar_url")
        val avatarUrl: String,

        @ColumnInfo(name = "htmlUrl")
        @field:SerializedName("html_url")
        val htmlUrl: String,

        @PrimaryKey
        @field:SerializedName("id")
        val id: Int
    ): Parcelable
}
