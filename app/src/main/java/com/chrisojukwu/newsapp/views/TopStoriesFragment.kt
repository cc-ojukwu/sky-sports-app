package com.chrisojukwu.newsapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.chrisojukwu.newsapp.models.NewsItem
import com.chrisojukwu.newsapp.viewmodel.NewsViewModel
import com.chrisojukwu.newsapp.adapters.TopStoriesAdapter
import com.chrisojukwu.newsapp.databinding.FragmentTopStoriesBinding

class TopStoriesFragment : Fragment() {

    private val sharedViewModel: NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTopStoriesBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = viewLifecycleOwner

        // Giving the binding access to the OverviewViewModel
        binding.sharedViewModel = sharedViewModel

        binding.recyclerViewHeadlines.adapter =
            TopStoriesAdapter { newsItem -> onNewsItemClick(newsItem) }

        return binding.root
    }

    private fun onNewsItemClick(newsItem: NewsItem) {

    }

}