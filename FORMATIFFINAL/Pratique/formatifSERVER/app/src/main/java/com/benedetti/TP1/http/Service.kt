package com.benedetti.TP1.http

import org.kickmyb.transfer.AddTaskRequest
import org.kickmyb.transfer.HomeItemResponse
import org.kickmyb.transfer.SigninRequest
import org.kickmyb.transfer.SigninResponse
import retrofit2.Call
import retrofit2.http.GET
import org.kickmyb.transfer.SignupRequest
import org.kickmyb.transfer.TaskDetailResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface Service {
    @GET("exam/h25/{x}")
    fun examGreet(@Path("x") name: String): Call<String>
}