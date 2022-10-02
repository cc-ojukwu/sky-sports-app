package com.chrisojukwu.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.chrisojukwu.newsapp.api.NewsApi
import com.chrisojukwu.newsapp.models.NewsItem
import kotlinx.coroutines.launch
import java.io.IOException

enum class NewsApiStatus { LOADING, DONE, ERROR }

class NewsViewModel : ViewModel() {

    private val _status = MutableLiveData<NewsApiStatus>()
    val status: LiveData<NewsApiStatus> = _status

    private val _topStoriesItem = MutableLiveData<MutableList<NewsItem>>()
    val topStoriesItem: LiveData<MutableList<NewsItem>> = _topStoriesItem

    init {
        getNews()

    }

    private fun getNews() {
        viewModelScope.launch {
            NewsApiStatus.LOADING
            try {
                val response = NewsApi.retrofitService.getNewsResponse(
                    apikey = "pub_102470fab747a7f00be27ca2d1556739c3d3f",
                    language = "en",
                    query = "football"
                )
                if (response.isSuccessful && response.body() != null) {
                    val rawResponse = response.body()!!.results

                    //initialize _newsList.value
                    _topStoriesItem.value = mutableListOf()

                    //remove array items that contain null image urls
                    for (newsItem in rawResponse) {
                        if (newsItem.image_url != null) {
                            _topStoriesItem.value?.add(newsItem)
                        }
                    }
                }
                Log.e("success", "Response successful")
                _status.value = NewsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = NewsApiStatus.ERROR
                Log.e("not successful", "Response not successful")
                //_newsList.value = mutableListOf()
            } catch (e: IOException) {
                _status.value = NewsApiStatus.ERROR
                Log.e("not successful", "IOException- perhaps no internet connection")
            }

        }
    }

}