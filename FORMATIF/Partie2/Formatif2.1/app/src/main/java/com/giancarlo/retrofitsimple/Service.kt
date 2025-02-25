package com.giancarlo.retrofitsimple

import com.giancarlo.retrofitsimple.transfer.Truc
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("exam/representations/{number}")
    fun listTrucs(@Path("number") number: String): Call<List<Truc>>
}