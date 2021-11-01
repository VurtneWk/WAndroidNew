package com.vurtnewk.play.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author VurtneWk
 * 2021/10/18
 */
open class BaseViewModel : ViewModel() {

    protected val _dataLoading = MutableLiveData(false)
    val dataLoading = _dataLoading
}