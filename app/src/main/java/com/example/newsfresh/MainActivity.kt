package com.example.newsfresh

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.newsfresh.adapter.NewsListAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    //lateinit var adapter: NewsListAdapter

    //lateinit var recycle : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val mydata : ArrayList<News> = fetchdata()

        //val recycle=findViewById<RecyclerView>(R.id.recyclerview)

        //recycle.adapter=NewsListAdapter(mydata)

        fetchdata()
    }

    private fun fetchdata(){


        var recycle=findViewById<RecyclerView>(R.id.recyclerview)
        var adapter : NewsListAdapter

        val news : Call<datalist> = Retro_interface.newsInstance.getHeadLines("in",1)

        news.enqueue(object : Callback<datalist>{

            override fun onResponse(call: Call<datalist>, response: retrofit2.Response<datalist>) {

                val news : datalist ? = response.body()

                if(news != null){
                    Log.d("CHEESYCODE",news.toString())

                    adapter = NewsListAdapter(this@MainActivity,news.articles)

                    //recycle=findViewById(R.id.recyclerview)
                    recycle.adapter=adapter

                    recycle.layoutManager = LinearLayoutManager(this@MainActivity)

                }
            }

            override fun onFailure(call: Call<datalist>, t: Throwable) {

                Log.d("CHEESYCODE","Error in fetching news",t)
            }
        })
    }
}