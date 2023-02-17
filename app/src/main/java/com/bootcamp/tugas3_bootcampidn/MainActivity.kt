package com.bootcamp.tugas3_bootcampidn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.tugas3_bootcampidn.api.ApiConfig
import com.bootcamp.tugas3_bootcampidn.api.NewsApi
import com.bootcamp.tugas3_bootcampidn.databinding.ActivityMainBinding
import com.bootcamp.tugas3_bootcampidn.model.ResponseNews
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiConfig.getService().getTopHeadlines("id", "f044de69086e45198f8406be2094a229")
            .enqueue(object : Callback<ResponseNews>){

            }

        val newsAdapter = NewsAdapter(newsList)

        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = newsAdapter
        }
    }
}