package com.benedetti.TP1.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.benedetti.TP1.R
import com.benedetti.TP1.UserSession
import com.benedetti.TP1.databinding.ActivityAccueilBinding
import com.benedetti.TP1.http.UtilitaireRetrofit
import org.kickmyb.transfer.HomeItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccueilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccueilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.Home)

        binding = ActivityAccueilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSendButton()
        // setupRecycler() et fillRecycler() restent pour d'autres besoins
        setupRecycler()
        fillRecycler()
    }
    private fun startDownload() {
        binding.btnSend.isEnabled = false
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun endDownload() {
        binding.btnSend.isEnabled = true
        binding.progressBar.visibility = View.GONE
    }

    private fun setupSendButton() {
        binding.btnSend.setOnClickListener {
            val name = binding.etName.text.toString()
            val service = UtilitaireRetrofit.get()
            startDownload()
            service.examGreet(name).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    // Afficher le résultat ou le message d’erreur selon le code de réponse
                    endDownload()
                    if (response.isSuccessful) {
                        binding.tvResult.text = response.body()
                    }else if (response.code() == 400) {
                        val errorMsg = response.errorBody()?.string()
                        binding.tvResult.text = errorMsg
                    } else
                    {
                        binding.tvResult.text = "Erreur : ${response.code()} - ${response.message()}"
                    }
                }
                override fun onFailure(call: Call<String>, t: Throwable) {
                    // Afficher un message d’erreur réseau
                    endDownload()
                    binding.tvResult.text = "Erreur réseau : ${t.localizedMessage ?: "Inconnue"}"
                }
            })
        }
    }

    private fun setupRecycler() {
        // Laisse vide ou implémente pour d'autres requêtes
    }

    private fun fillRecycler() {
        // Laisse vide ou implémente pour d'autres requêtes
    }
}