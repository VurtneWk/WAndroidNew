package com.vurtnewk.play.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vurtnewk.play.data.HttpResult
import com.vurtnewk.play.data.UserInfo
import com.vurtnewk.play.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author VurtneWk
 * 2021/10/8
 */

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    private val _loginBean = MutableLiveData<HttpResult<UserInfo>>()
    val loginBean = _loginBean

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val login = userRepository.login(username, password)
            _loginBean.value = login
        }
    }

}