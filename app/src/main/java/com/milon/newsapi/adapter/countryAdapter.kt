package com.milon.newsapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.milon.newsapi.databinding.ItemLayoutBinding
import com.milon.newsapi.model.Article
import com.milon.newsapi.model.countryList

class countryAdapter(val context: Context, val article: List<Article>): RecyclerView.Adapter<countryAdapter.coViewHolder>(){

    class coViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): coViewHolder {
        return coViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: coViewHolder, position: Int) {
        val article= article[position]
        holder.binding.textTitle.text= article.title
        holder.binding.textDescription.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.binding.imageView)

    }

    override fun getItemCount(): Int {
        return article.size
    }



}