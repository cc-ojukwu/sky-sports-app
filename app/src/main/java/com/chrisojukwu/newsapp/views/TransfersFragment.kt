package com.chrisojukwu.newsapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrisojukwu.newsapp.databinding.FragmentTransfersBinding

class TransfersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTransfersBinding.inflate(inflater)

        return  binding.root
    }




}