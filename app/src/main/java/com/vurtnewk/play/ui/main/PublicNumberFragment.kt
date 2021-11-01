package com.vurtnewk.play.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.vurtnewk.play.R
import com.vurtnewk.play.base.BaseFragment
import com.vurtnewk.play.databinding.FragmentProjectBinding
import com.vurtnewk.play.databinding.FragmentPublicNumberBinding

/**
 * @author VurtneWk
 * 2021/10/15
 */
class PublicNumberFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentPublicNumberBinding>(inflater, R.layout.fragment_public_number,container,false)
        return binding.root
    }
}