package com.chrisojukwu.newsapp.adapters

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.chrisojukwu.newsapp.viewmodel.NewsApiStatus
import com.chrisojukwu.newsapp.models.NewsItem
import com.chrisojukwu.newsapp.R

//use coil library to display image urls in image view
@BindingAdapter("imageViewUrl")
fun bindImage(imgView: ImageView, img_url: String?) {
    img_url?.let {
        val imgUri = img_url.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("newsApiStatus")
fun bindStatus(statusImageView: ImageView, status: NewsApiStatus?) {
    when (status) {
        NewsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        NewsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        NewsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

//pass API response data to adapter for Headlines Fragment
@BindingAdapter("newsItemList")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<NewsItem>?) {
    val adapter = recyclerView.adapter as TopStoriesAdapter
    adapter.submitList(data)
}




