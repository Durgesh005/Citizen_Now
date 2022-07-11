package com.example.citizennow.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.citizennow.Controller.TabLayoutAdapter
import com.example.citizennow.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)


        binding.TabView.addTab(binding.TabView.newTab().setText("All Feed"))
        binding.TabView.addTab(binding.TabView.newTab().setText("Business"))
        binding.TabView.addTab(binding.TabView.newTab().setText("Industry"))
        binding.TabView.addTab(binding.TabView.newTab().setText("Politics"))


        var adapter = TabLayoutAdapter(activity, childFragmentManager, 4)
        binding.viewPager.adapter = adapter
        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.TabView))

        binding.TabView.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        return binding.root
    }
}

