package com.vurtnewk.play.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.orhanobut.logger.Logger
import com.vurtnewk.play.R
import com.vurtnewk.play.databinding.ActivityLoginBinding
import com.vurtnewk.play.ext.setNoFastClickListener
import com.vurtnewk.play.vm.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * @author VurtneWk
 * 2021/10/8
 */
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private val mLoginViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.btnLogin.setNoFastClickListener {
//            lifecycleScope.launch{
            mLoginViewModel.login("vurtnewk", "111111")
//                data.onSuccess {
//                    Logger.d(data)
//                }
//            }
        }
        mLoginViewModel.loginBean.observe(this, { result ->
            Logger.d(result.data)
        })

    }

}