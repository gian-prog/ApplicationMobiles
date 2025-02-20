package com.giancarlo.retrofitsimple

import com.giancarlo.retrofitsimple.transfer.Truc
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("exos/long/list")
    fun listLongs(): Call<List<Long>>

    @GET("exos/truc/list")
    fun listTrucs(): Call<List<Truc>>
}