package com.vurtnewk.play.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.orhanobut.logger.Logger
import com.vurtnewk.play.R
import com.vurtnewk.play.adapter.ArticleAdapter
import com.vurtnewk.play.base.BaseFragment
import com.vurtnewk.play.data.ViewStatus
import com.vurtnewk.play.databinding.FragmentHomeBinding
import com.vurtnewk.play.vm.main.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author VurtneWk
 * 2021/10/14
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val mHomeViewModel: HomeViewModel by viewModels()

    private lateinit var mArticleAdapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mArticleAdapter = ArticleAdapter(mHomeViewModel)

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        ).apply {
            rvArticle.adapter = mArticleAdapter
            viewModels = mHomeViewModel
            lifecycleOwner = this@HomeFragment.viewLifecycleOwner
        }
        mHomeViewModel.getHomeArticles(true)

        binding.smartRefreshLayout.setOnRefreshListener {
            mHomeViewModel.getHomeArticles(true)
        }
        binding.smartRefreshLayout.setOnLoadMoreListener {
            mHomeViewModel.getHomeArticles(false)
        }
        //
//        mHomeViewModel.dataLoading.observe(viewLifecycleOwner, {
//            if (!it) {
//                binding.smartRefreshLayout.finishRefresh()
//                binding.smartRefreshLayout.finishLoadMore()
//            }
//        })
        mHomeViewModel.articlesData.observe(viewLifecycleOwner, {
            when (it) {
                is ViewStatus.Loading -> {
//                    Logger.d("Loading")
                }
                is ViewStatus.Error -> Logger.d("Error")
                is ViewStatus.Success -> {

                    binding.smartRefreshLayout.finishRefresh()
                    binding.smartRefreshLayout.finishLoadMore()
//                    Logger.d("Success -》 ${it.hashCode()} , ${it.data.size}")
                    mArticleAdapter.submitList(it.data)
                }
            }
        })
        return binding.root
    }
}