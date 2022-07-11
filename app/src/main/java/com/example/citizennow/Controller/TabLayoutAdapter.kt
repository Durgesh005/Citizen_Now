package com.example.citizennow.Controller

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.citizennow.Fragment.ChildFragment.*

class TabLayoutAdapter(
    activity: FragmentActivity?,
    supportFragmentManger: FragmentManager,
    i: Int
) :
    FragmentPagerAdapter(supportFragmentManger) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> AllFeedFragment()
            1 -> BusinessFragment()
            2 -> IndustryFragment()
            else -> PoliticsFragment()
        }
    }
}