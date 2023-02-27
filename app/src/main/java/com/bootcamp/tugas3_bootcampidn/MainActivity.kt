package com.bootcamp.tugas3_bootcampidn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.tugas3_bootcampidn.api.ApiConfig
import com.bootcamp.tugas3_bootcampidn.databinding.ActivityMainBinding
import com.bootcamp.tugas3_bootcampidn.model.ArticlesItem
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


        ApiConfig.getService().getNews("id", "f044de69086e45198f8406be2094a229").enqueue(object : Callback<ResponseNews> {
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                if (response.isSuccessful) {
                    val responseNews = response.body()
                    val dataNews = responseNews?.articles
                    val newsAdapter = NewsAdapter()
                    newsAdapter.setData(dataNews as List<ArticlesItem>)
                    binding.rvNews.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = newsAdapter
                    }
                } else {
                    Log.d("response",response.errorBody().toString())
                    // Handle API error
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Log.d("response",t.message + " " + t.cause)
            }
        })


        val newsAdapter = NewsAdapter()

        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = newsAdapter
        }
    }
}


