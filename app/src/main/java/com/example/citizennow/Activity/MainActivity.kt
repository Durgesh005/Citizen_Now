package com.example.citizennow.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.citizennow.Activity.ApiClient.Companion.Retrofit
import com.example.citizennow.Adapter.Adapter
import com.example.citizennow.Fragment.CategoryFragment
import com.example.citizennow.Fragment.HomeFragment
import com.example.citizennow.Fragment.SearchFragment
import com.example.citizennow.Fragment.UserFragment
import com.example.citizennow.R
import com.example.citizennow.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var binding: ActivityMainBinding
        var list = listOf<ArticlesItem?>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadfragment(HomeFragment())
        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val categoryFragment = CategoryFragment()
        val userFragment = UserFragment()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.Home -> loadfragment(homeFragment)
                R.id.Headlines -> loadfragment(searchFragment)
                R.id.Following -> loadfragment(categoryFragment)
                R.id.User -> loadfragment(userFragment)

            }
            true
        }

    }

    override fun onStart() {
        NewsApi("in", "business")
        super.onStart()
    }

    fun loadfragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Viewpager, fragment)
            commit()
        }
    }

    fun NewsApi(Countery: String, Category: String) {
        var apiInterface = Retrofit().create(ApiInterface::class.java)
        apiInterface.getNews(Countery, Category, "3f2987671fbb4dd0bc643e8b2d278d35")
            .enqueue(object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    Log.e("TAG", "onResponse: ${response.body()}")
                    val temp = response.body()
                    list = temp?.articles!!

                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.e("TAG", "onResponse: ${t.message}")

                }


            })
    }


}