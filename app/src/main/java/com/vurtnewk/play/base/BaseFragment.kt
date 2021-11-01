package com.vurtnewk.play.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings
import com.vurtnewk.play.databinding.FragmentKnowledgeSystemBinding

/**
 * @author VurtneWk
 * 2021/10/14
 */
abstract class BaseFragment: Fragment() {

    private lateinit var _binding: ViewBinding
//    protected val binding: VB get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding.root
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    fun setTitle() {

    }
}