package com.giancarlo.retrofitsimple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.giancarlo.retrofitsimple.adapters.LongAdapter
import com.giancarlo.retrofitsimple.adapters.TrucAdapter
import com.giancarlo.retrofitsimple.databinding.ActivityMainBinding
import com.giancarlo.retrofitsimple.transfer.Truc
import com.giancarlo.retrofitsimple.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var longAdapter: LongAdapter
    private lateinit var trucAdapter: TrucAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerViews()
        fetchLongList()
        fetchTrucList()
    }

    private fun setupRecyclerViews() {
        longAdapter = LongAdapter()
        trucAdapter = TrucAdapter()

        binding.rvLongList.adapter = longAdapter
        binding.rvLongList.setHasFixedSize(true)
        binding.rvLongList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        binding.rvTrucList.adapter = trucAdapter
        binding.rvTrucList.setHasFixedSize(true)
        binding.rvTrucList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun fetchLongList() {
        RetrofitUtil.get().listLongs().enqueue(object : Callback<List<Long>> {
            override fun onResponse(call: Call<List<Long>>, response: Response<List<Long>>) {
                longAdapter.submitList(response.body())
            }

            override fun onFailure(call: Call<List<Long>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun fetchTrucList() {
        RetrofitUtil.get().listTrucs().enqueue(object : Callback<List<Truc>> {
            override fun onResponse(call: Call<List<Truc>>, response: Response<List<Truc>>) {
                trucAdapter.submitList(response.body())
            }

            override fun onFailure(call: Call<List<Truc>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}