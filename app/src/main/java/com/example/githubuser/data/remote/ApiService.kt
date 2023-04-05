package com.example.githubuser.data.remote

import com.example.githubuser.BuildConfig
import com.example.githubuser.data.model.DetailUserResponse
import com.example.githubuser.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ApiService {

    @JvmSuppressWildcards
    @GET("users")
    @Headers("Authorization: token " + BuildConfig.API_TOKEN)
    suspend fun getUsers(): MutableList<UserResponse.Item>

    @JvmSuppressWildcards
    @GET("users/{username}")
    @Headers("Authorization: token " + BuildConfig.API_TOKEN)
    suspend fun getDetailUser(@Path("username") username: String): DetailUserResponse

    @JvmSuppressWildcards
    @GET("/users/{username}/followers")
    @Headers("Authorization: token " + BuildConfig.API_TOKEN)
    suspend fun getFollowersUser(@Path("username") username: String): MutableList<UserResponse.Item>

    @JvmSuppressWildcards
    @GET("/users/{username}/following")
    @Headers("Authorization: token " + BuildConfig.API_TOKEN)
    suspend fun getFollowingUser(@Path("username") username: String): MutableList<UserResponse.Item>

    @JvmSuppressWildcards
    @GET("search/users")
    @Headers("Authorization: token " + BuildConfig.API_TOKEN)
    suspend fun getSearchUsers(@QueryMap params: Map<String, Any>): UserResponse
}