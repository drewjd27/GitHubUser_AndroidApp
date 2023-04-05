package com.example.githubuser.data.model

import com.google.gson.annotations.SerializedName

class User(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("login")
    val login: String,

    @field:SerializedName("avatar_url")
    val avatarUrl: String,

    @field:SerializedName("html_url")
    val htmlUrl: String,

    @field:SerializedName("following_url")
    val followingUrl: String,

    @field:SerializedName("following")
    val following: Int,

    @field:SerializedName("followers_url")
    val followersUrl: String,

    @field:SerializedName("followers")
    val followers: Int
)