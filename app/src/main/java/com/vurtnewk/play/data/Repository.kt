package com.vurtnewk.play.data

import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author VurtneWk
 * 2021/10/15
 */
@Singleton
class Repository @Inject constructor(private val remoteSource: RemoteSource) {

    suspend fun getHomeArticle(page: Int): HttpResult<HomeArticleList> {
//        return try {
//            Result.Success(articleRemoteSource.getHomeArticleList(page))
//        } catch (e: Exception) {
//            Result.Error(e)
//        }
        return remoteSource.getHomeArticleList(page)
    }

    suspend fun getKnowledgeSystemList(): HttpResult<List<KnowledgeSystemItem>> {
        return remoteSource.getKnowledgeSystemList()
    }
}