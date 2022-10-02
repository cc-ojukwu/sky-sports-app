package com.chrisojukwu.newsapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.chrisojukwu.newsapp.R
import com.chrisojukwu.newsapp.databinding.FragmentWatchBinding

class WatchFragment : Fragment() {

    private lateinit var binding: FragmentWatchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Set a custom view for the ActionBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.displayOptions =
            androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM
        (activity as AppCompatActivity?)!!.supportActionBar!!.setCustomView(R.layout.action_bar_custom)

        // Inflate the layout for this fragment
        binding = FragmentWatchBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}