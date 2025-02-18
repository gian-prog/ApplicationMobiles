package org.depinfo.retrofit_demo.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface service {
    @GET("exos/truc/complexe")
    fun listReposString(@Query("name") name: String): Call<String>
}