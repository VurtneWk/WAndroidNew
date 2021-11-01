package com.vurtnewk.play.data

import java.lang.Exception

/**
 * @author VurtneWk
 * 2021/10/18
 * 返回的结果
 */
sealed class ViewStatus<out R> {

    data class Success<out T>(val data: T) : ViewStatus<T>()
    data class Error(val e: Exception?) : ViewStatus<Nothing>()
    object Loading : ViewStatus<Nothing>()

}