package com.chrisojukwu.newsapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.chrisojukwu.newsapp.R
import com.chrisojukwu.newsapp.adapters.FragmentContainerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ContainerFragment : Fragment() {
    private lateinit var fragmentContainerAdapter: FragmentContainerAdapter
    private lateinit var viewPager: ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Set a custom view for the ActionBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.displayOptions =
            androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM
        (activity as AppCompatActivity?)!!.supportActionBar!!.setCustomView(R.layout.action_bar_custom)
//
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_container, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentContainerAdapter = FragmentContainerAdapter(this)

        //Implement the viewPager for the Container Fragment
        viewPager = view.findViewById(R.id.view_pager_container)
        viewPager.adapter = fragmentContainerAdapter
        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Top Stories"
                1 -> tab.text = "My Sports"
                2 -> tab.text = "Transfers"
            }
        }.attach()
    }
}




