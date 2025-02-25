package org.depinfo.retrofit_demo.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface service {
    @GET("exam/representations/{number}")
    fun listNombres(@Path("number") number: Int): Call<String>
}