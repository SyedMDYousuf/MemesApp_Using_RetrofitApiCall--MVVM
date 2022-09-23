package com.syedmohammedyousuf.memesapp.network

import com.syedmohammedyousuf.memesapp.models.Meme
import com.syedmohammedyousuf.memesapp.models.MemesResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("/get_memes")
    fun getData(): Call<List<Meme>>
}