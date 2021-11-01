package com.vurtnewk.play.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.vurtnewk.play.R
import com.vurtnewk.play.base.BaseFragment
import com.vurtnewk.play.databinding.FragmentLoginBinding

/**
 * @author VurtneWk
 * 2021/10/15
 */
class LoginFragment:BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login,container,false)
        return binding.root
    }
}