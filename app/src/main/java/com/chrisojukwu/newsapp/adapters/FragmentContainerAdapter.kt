package com.chrisojukwu.newsapp.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chrisojukwu.newsapp.views.*

class FragmentContainerAdapter( fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    //Initialize list of fragments to be added to the viewPager
    private val fragmentList: List<Fragment> = listOf( TopStoriesFragment(), MySportsFragment(), TransfersFragment())

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {

        // Return a NEW fragment instance in createFragment(int)
        return fragmentList[position]
    }
}