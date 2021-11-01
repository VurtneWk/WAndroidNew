package com.vurtnewk.play.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vurtnewk.play.adapter.ArticleAdapter.ViewHolder
import com.vurtnewk.play.data.Article
import com.vurtnewk.play.databinding.ArticleItemBinding
import com.vurtnewk.play.vm.main.HomeViewModel

/**
 * @author VurtneWk
 * 2021/10/15
 */
class ArticleAdapter(private val homeViewModel: HomeViewModel) :
    ListAdapter<Article, ViewHolder>(COMPARATOR) {

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding(homeViewModel, item)
    }

    class ViewHolder private constructor(val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binding(homeViewModel: HomeViewModel, item: Article) {
            binding.article = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ArticleItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

