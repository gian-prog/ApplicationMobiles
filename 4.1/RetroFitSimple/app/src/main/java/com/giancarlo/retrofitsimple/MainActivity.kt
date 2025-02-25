package com.giancarlo.retrofitsimple

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.giancarlo.retrofitsimple.databinding.ActivityMainBinding
import org.depinfo.retrofit_demo.TestsHTTP
import org.depinfo.retrofit_demo.http.RetrofitUtil
import org.depinfo.retrofit_demo.http.service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())

        // appeler un service de liste et afficher dans le textview
        binding.button.setOnClickListener({
            val service: service = RetrofitUtil.get()
            val nom: String = binding.allo.text.toString()
            val call: Call<String> = service.listNombres(nom)
            call.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful) {
                        // http 200 http tout s'est bien passé
                        val resultat = response.body()
                        Toast.makeText(this@MainActivity, resultat, Toast.LENGTH_LONG).show()
                        binding.tv.text = resultat
                    } else {
                        // cas d'erreur http 400 404 etc.
                        Toast.makeText(this@MainActivity, "REPONSE ERREUR : " + response.code(), Toast.LENGTH_LONG).show()
                        binding.tv.text = "REPONSE ERREUR : " + response.code()
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    // erreur accès réseau ou alors GSON
                    binding.tv.text = "PAS DE REPONSE : " + t.message
                }
            })
        })
    }
}