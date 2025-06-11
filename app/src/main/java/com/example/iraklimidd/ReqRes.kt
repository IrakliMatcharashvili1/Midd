package com.example.iraklimidd

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqRes {
    @GET("Mid")
    fun getTeams(@Query("page") page: Int): Call<ReqresObj<List<Teams>>>
}