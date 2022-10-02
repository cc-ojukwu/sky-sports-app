package com.chrisojukwu.newsapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisojukwu.newsapp.databinding.FragmentMySportsBinding


class MySportsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentMySportsBinding.inflate(inflater)

        return  binding.root
    }


}