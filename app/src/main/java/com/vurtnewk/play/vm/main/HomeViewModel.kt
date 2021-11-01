package com.vurtnewk.play.vm.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vurtnewk.play.base.BaseViewModel
import com.vurtnewk.play.data.Article
import com.vurtnewk.play.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.vurtnewk.play.data.ViewStatus

/**
 * @author VurtneWk
 * 2021/10/15
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {

//    private val _articleItems: MutableLiveData<MutableList<Article>> = MutableLiveData()
//    val articleItems: LiveData<MutableList<Article>> = _articleItems

    private val articles = mutableListOf<Article>()

    private var page = 0

    private val _articles : MutableLiveData<ViewStatus<MutableList<Article>>> = MutableLiveData()
    val articlesData = _articles

    fun getHomeArticles(isRefresh: Boolean) {
//        _dataLoading.value = true
        _articles.value = ViewStatus.Loading
        viewModelScope.launch {
            if (isRefresh) {
                page = 0
                articles.clear()
            } else {
                page++
            }
            val homeArticle = repository.getHomeArticle(page)

            articles.addAll(homeArticle.data.datas)

            _articles.value = ViewStatus.Success(mutableListOf<Article>().apply {
                addAll(articles)
            })


//            _dataLoading.value = false
        }
    }
}

