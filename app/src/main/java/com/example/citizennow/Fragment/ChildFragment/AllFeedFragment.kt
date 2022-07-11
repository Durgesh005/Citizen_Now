package com.example.citizennow.Fragment.ChildFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.citizennow.Activity.ArticlesItem
import com.example.citizennow.Activity.MainActivity.Companion.list
import com.example.citizennow.Adapter.Adapter
import com.example.citizennow.databinding.FragmentCurrentBinding

class AllFeedFragment : Fragment() {
    lateinit var binding: FragmentCurrentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCurrentBinding.inflate(layoutInflater)
        Adapter2(list)
        Log.e("TAG", "onCreateView: ${list}" )
        return binding.root
    }

    fun Adapter2(l1: List<ArticlesItem?>)
    {
        var adapter= Adapter(l1)
        var layoutManager=LinearLayoutManager(activity)
        binding.AllFeedView.adapter=adapter
        binding.AllFeedView.layoutManager=layoutManager

    }

}