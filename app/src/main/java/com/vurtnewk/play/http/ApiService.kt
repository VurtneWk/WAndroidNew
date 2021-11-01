package com.vurtnewk.play.http

import com.vurtnewk.play.data.HomeArticleList
import com.vurtnewk.play.data.HttpResult
import com.vurtnewk.play.data.KnowledgeSystemItem
import com.vurtnewk.play.data.UserInfo
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author VurtneWk
 * 2021/10/8
 */
interface ApiService {

    @POST("/user/login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): HttpResult<UserInfo>

    @GET("/article/list/{page}/json")
    suspend fun getHomeArticle(@Path("page") page: Int): HttpResult<HomeArticleList>

    @GET("/tree/json")
    suspend fun getKnowledgeSystemList(): HttpResult<List<KnowledgeSystemItem>>
}