package com.milon.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.milon.newsapi.adapter.countryAdapter
import com.milon.newsapi.databinding.ActivityMainBinding
import com.milon.newsapi.model.Article
import com.milon.newsapi.model.countryList
import com.milon.newsapi.retrofitHelper.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: countryAdapter

    private val API_KEY= "3a29c93a2e2c4e22a9982149d5e68528"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.recycler.setHasFixedSize(true)


        val re=   RetrofitInstance.apiInterface.getData(API_KEY, "in", 1)
        re.enqueue(object : Callback<countryList?> {
            override fun onResponse(call: Call<countryList?>, response: Response<countryList?>) {
                val repo = response.body()

                if (repo != null) {
                    adapter= countryAdapter(this@MainActivity, repo.articles)
                    binding.recycler.adapter = adapter
                    binding.recycler.layoutManager= LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<countryList?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })



      // category()

    }

    private fun category() {
        val re=   RetrofitInstance.apiInterface.getData(API_KEY, "in", 1)
        re.enqueue(object : Callback<countryList?> {
            override fun onResponse(call: Call<countryList?>, response: Response<countryList?>) {
                val repo = response.body()?.articles

//                if (repo != null) {
//                    for (array in repo) {
//                        binding.memeAuthor.text = array.author
//                        binding.memeTitle.text = array.content
//
//                    }
//
//                }
            }

            override fun onFailure(call: Call<countryList?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })




    }
}