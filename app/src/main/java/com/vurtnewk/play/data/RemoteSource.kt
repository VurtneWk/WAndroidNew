package com.vurtnewk.play.data

import com.vurtnewk.play.data.HomeArticleList
import com.vurtnewk.play.data.HttpResult
import com.vurtnewk.play.data.KnowledgeSystemItem
import com.vurtnewk.play.http.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author VurtneWk
 * 2021/10/15
 */
class RemoteSource @Inject constructor(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getHomeArticleList(page: Int): HttpResult<HomeArticleList> {
        return withContext(ioDispatcher) {
            apiService.getHomeArticle(page)
        }
    }

    suspend fun getKnowledgeSystemList(): HttpResult<List<KnowledgeSystemItem>> {
        return apiService.getKnowledgeSystemList()
    }
}