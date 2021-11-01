package com.vurtnewk.play.data

import com.vurtnewk.play.http.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author VurtneWk
 * 2021/10/8
 * 用户相关数据源
 */
class UserSource @Inject constructor(
    private val service: ApiService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun login(username: String, password: String): HttpResult<UserInfo> {
        return withContext(ioDispatcher) { service.login(username, password) }
    }

}