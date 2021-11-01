package com.vurtnewk.play.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.orhanobut.logger.Logger
import com.vurtnewk.play.R
import com.vurtnewk.play.base.BaseFragment
import com.vurtnewk.play.databinding.FragmentKnowledgeSystemBinding
import com.vurtnewk.play.vm.KnowledgeSystemViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author VurtneWk
 * 2021/10/14
 */
@AndroidEntryPoint
class KnowledgeSystemFragment : BaseFragment() {

    private var _binding: FragmentKnowledgeSystemBinding? = null
    private val binding get() = _binding!!

    private val mKnowledgeSystemViewModel: KnowledgeSystemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKnowledgeSystemBinding.inflate(inflater)
        binding.title.apply {
            tvTitle.text = "知识体系"
            ivLeftIcon.setOnClickListener {

            }
            ivRightIcon.setImageResource(R.drawable.ic_filter_menu)
            ivRightIcon.setOnClickListener {
                findNavController().navigate(R.id.action_knowledge_system_to_knowledgeSystemListFragment)
            }
        }
        mKnowledgeSystemViewModel.getKnowledgeSystemList()
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}