package com.vurtnewk.play.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author VurtneWk
 * 2021/10/15
 */
@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    //控制是否显示底部导航栏
    private val _isShowBottomNavigationView = MutableLiveData(true)
    val isShowBottomNavigationView: LiveData<Boolean> = _isShowBottomNavigationView

    fun setNavigationShow(isShow: Boolean) {
        _isShowBottomNavigationView.value = isShow
    }
}