package com.example.githubuser.data.model

import com.google.gson.annotations.SerializedName

data class DetailUserResponse(

    @field:SerializedName("repos_url")
    val reposUrl: String,

    @field:SerializedName("following")
    val following: Int,

    @field:SerializedName("following_url")
    val followingUrl: String,

    @field:SerializedName("bio")
    val bio: Any,

    @field:SerializedName("login")
    val login: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("followers")
    val followers: Int,

    @field:SerializedName("followers_url")
    val followersUrl: String,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("avatar_url")
    val avatarUrl: String,

    @field:SerializedName("html_url")
    val htmlUrl: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("location")
    val location: String,

    @field:SerializedName("node_id")
    val nodeId: String
)
