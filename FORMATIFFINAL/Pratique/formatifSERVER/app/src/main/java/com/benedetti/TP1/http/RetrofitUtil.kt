package com.benedetti.TP1.http
import okhttp3.OkHttpClient
import org.kickmyb.CustomGson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object UtilitaireRetrofit {
    private var instance: Service? = null

    fun get(): Service {
        if (instance == null) { //  ca sera le cas au tout premier appel
            // se faire un Gson modifié pour respecter le format de date "2069-05-24T12:12:12"

            val retrofit = Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(CustomGson.getIt()))
                .client(client())
//                .baseUrl("http://10.0.2.2:8080/") //Pour Débogage
                .baseUrl("https://fourn6-mobile-prof.onrender.com/")    //Serveur Render
                .build()
            instance = retrofit.create<Service?>(Service::class.java)
            return instance!!
        } else {
            return instance!!
        }
    }

    private fun client(): OkHttpClient {
        return OkHttpClient.Builder()
            .cookieJar(SessionCookieJar)
            .build()
    }
}
