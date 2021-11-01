package com.vurtnewk.play.data

import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author VurtneWk
 * 2021/10/8
 * 对外提供的数据
 */
@Singleton
class UserRepository @Inject constructor(private val userSource: UserSource) {

    suspend fun login(username: String, password: String): HttpResult<UserInfo> {
        return userSource.login(username, password)
    }

}