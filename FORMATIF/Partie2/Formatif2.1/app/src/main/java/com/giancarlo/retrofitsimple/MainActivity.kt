package com.giancarlo.retrofitsimple

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.giancarlo.retrofitsimple.adapters.TrucAdapter
import com.giancarlo.retrofitsimple.databinding.ActivityMainBinding
import com.giancarlo.retrofitsimple.transfer.Truc
import com.giancarlo.retrofitsimple.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var trucAdapter: TrucAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerViews()
        binding.fetchBtn.setOnClickListener {
            fetchTrucList()
        }
    }

    private fun setupRecyclerViews() {
        trucAdapter = TrucAdapter()
        binding.rvTrucList.adapter = trucAdapter
        binding.rvTrucList.setHasFixedSize(true)
        binding.rvTrucList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun fetchTrucList() {
        val numberInput = binding.numberInput.text.toString()
        RetrofitUtil.get().listTrucs(numberInput).enqueue(object : Callback<List<Truc>> {
            override fun onResponse(call: Call<List<Truc>>, response: Response<List<Truc>>) {
                response.body()?.let { trucList ->
                    trucAdapter.submitList(trucList)
                    for (truc in trucList) {
                        Log.d("MainActivity", "Truc: nombre=${truc.nombre}, description=${truc.description}, representation=${truc.representation}")
                    }
                }
            }

            override fun onFailure(call: Call<List<Truc>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}