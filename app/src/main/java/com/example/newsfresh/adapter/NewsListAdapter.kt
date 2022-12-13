package com.example.newsfresh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsfresh.News
import com.example.newsfresh.R

class NewsListAdapter(val context : Context , val  News : List<News>) : RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>(){


    class NewsViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){

        var newsimage = itemview.findViewById<ImageView>(R.id.imageview4)
        var title = itemview.findViewById<TextView>(R.id.title)
        var Desc = itemview.findViewById<TextView>(R.id.desc)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {

        return News.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        val current = News[position]

        holder.title.text = current.title
        holder.Desc.text=current.description

        Glide.with(context).load(current.urlToImage).into(holder.newsimage)
    }

}



