package org.depinfo.retrofit_demo.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface service {
    @GET("exam/representations/{number}")
    fun listNombres(@Path("number") number: String): Call<String>
}