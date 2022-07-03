package com.example.streettruck.getpostsapp.service

import com.example.streettruck.getpostsapp.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostListApi {

    @GET("/posts")
    suspend fun getPosts() : Response<List<Post>>
}
