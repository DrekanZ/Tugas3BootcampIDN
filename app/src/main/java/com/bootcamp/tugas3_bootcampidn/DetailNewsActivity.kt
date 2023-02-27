package com.bootcamp.tugas3_bootcampidn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailNewsActivity : AppCompatActivity() {

	companion object{
		const val EXTRA_NEWS = "extra_news"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail_news)


	}
}