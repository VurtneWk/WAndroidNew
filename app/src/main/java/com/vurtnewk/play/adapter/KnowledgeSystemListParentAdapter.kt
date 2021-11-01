package com.vurtnewk.play.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger
import com.vurtnewk.play.R
import com.vurtnewk.play.data.KnowledgeSystemItem
import com.vurtnewk.play.databinding.ItemKnowledgeSystemListChildBinding
import com.vurtnewk.play.databinding.ItemKnowledgeSystemListParentBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * @author VurtneWk
 * 2021/10/23
 */
class KnowledgeSystemListParentAdapter(private val clickCallBack: (View?, KnowledgeSystemItem, Int) -> Unit) :
    ListAdapter<KnowledgeSystemItem, KnowledgeSystemListParentAdapter.ViewHolder>(COMPARATOR) {

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<KnowledgeSystemItem>() {
            override fun areItemsTheSame(
                oldItem: KnowledgeSystemItem,
                newItem: KnowledgeSystemItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: KnowledgeSystemItem,
                newItem: KnowledgeSystemItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding(item)
        holder.binding.root.setOnClickListener {
            clickCallBack.invoke(it, item, position)
        }
    }

//    override fun getItemId(position: Int): Long {
//        return getItem(position).id.toLong()
//    }

    class ViewHolder private constructor(val binding: ItemKnowledgeSystemListParentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binding(item: KnowledgeSystemItem) {
            binding.apply {
                tvParentTitle.text = item.name
                if (item.selected) {
                    tvParentTitle.setTextColor(ContextCompat.getColor(tvParentTitle.context, R.color.primary))
                } else {
                    tvParentTitle.setTextColor(ContextCompat.getColor(tvParentTitle.context, R.color.primary_text))
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ItemKnowledgeSystemListParentBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class KnowledgeSystemListChildAdapter(private val clickCallBack: (View?, KnowledgeSystemItem.Children, Int) -> Unit) :
    ListAdapter<KnowledgeSystemItem.Children, KnowledgeSystemListChildAdapter.ViewHolder>(COMPARATOR) {

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<KnowledgeSystemItem.Children>() {
            override fun areItemsTheSame(
                oldItem: KnowledgeSystemItem.Children,
                newItem: KnowledgeSystemItem.Children
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: KnowledgeSystemItem.Children,
                newItem: KnowledgeSystemItem.Children
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding(item)
    }

    class ViewHolder private constructor(val binding: ItemKnowledgeSystemListChildBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binding(item: KnowledgeSystemItem.Children) {
            binding.tvChildTitle.text = item.name
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ItemKnowledgeSystemListChildBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}