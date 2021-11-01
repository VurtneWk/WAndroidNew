package com.vurtnewk.play.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Transformations
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.SimpleItemAnimator
import com.orhanobut.logger.Logger
import com.vurtnewk.play.adapter.KnowledgeSystemListChildAdapter
import com.vurtnewk.play.adapter.KnowledgeSystemListParentAdapter
import com.vurtnewk.play.base.BaseFragment
import com.vurtnewk.play.data.KnowledgeSystemItem
import com.vurtnewk.play.data.ViewStatus
import com.vurtnewk.play.databinding.FragmentKnowledgeSystemListBinding
import com.vurtnewk.play.vm.KnowledgeSystemViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * @author VurtneWk
 * 2021/10/23
 */
@AndroidEntryPoint
class KnowledgeSystemListFragment : BaseFragment() {

    private var _binding: FragmentKnowledgeSystemListBinding? = null
    private val binding get() = _binding!!

    private val mViewModel: KnowledgeSystemViewModel by activityViewModels()
    private lateinit var mKnowledgeSystemListParentAdapter: KnowledgeSystemListParentAdapter
    private lateinit var mKnowledgeSystemListChildAdapter: KnowledgeSystemListChildAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKnowledgeSystemListBinding.inflate(inflater)
        initData()
        return binding.root
    }

    private fun initData() {
        mKnowledgeSystemListParentAdapter =
            KnowledgeSystemListParentAdapter { view, knowledgeSystemItem, i ->
                mViewModel.setSelectParentPosition(i)
            }
        mKnowledgeSystemListChildAdapter = KnowledgeSystemListChildAdapter { view, children, i ->

        }
        binding.apply {
            rvParent.adapter = mKnowledgeSystemListParentAdapter
            rvChild.adapter = mKnowledgeSystemListChildAdapter
            rvParent.itemAnimator = null
        }

        mViewModel.knowledgeSystemListData.observe(viewLifecycleOwner, {
            when (it) {
                is ViewStatus.Loading -> {
                    Logger.d("Loading")
                }
                is ViewStatus.Success -> {
                    val mutableListOf = mutableListOf<KnowledgeSystemItem>()
                    mutableListOf.addAll(it.data)
                    mKnowledgeSystemListParentAdapter.submitList(mutableListOf)
                    mKnowledgeSystemListChildAdapter.submitList(mutableListOf[0].children)
                }
                is ViewStatus.Error -> {
                    Logger.d("Error")
                }
            }
        })
        mViewModel.knowledgeSystemChildData.observe(viewLifecycleOwner, {
            mKnowledgeSystemListChildAdapter.submitList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}