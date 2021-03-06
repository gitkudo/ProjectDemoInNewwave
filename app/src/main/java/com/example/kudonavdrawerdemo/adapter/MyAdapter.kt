package com.example.kudonavdrawerdemo.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.newwavesell.fragment.RegisterFragment
import com.example.newwavesell.fragment.LoginFragment

class MyAdapter(private val myContext: Context, fm: FragmentManager, private var totalTabs: Int) :
    FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                RegisterFragment()
            }
            1 -> {
                LoginFragment()
            }
            else -> RegisterFragment()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}