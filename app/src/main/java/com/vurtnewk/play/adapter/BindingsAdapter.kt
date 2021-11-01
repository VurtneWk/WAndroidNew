package com.vurtnewk.play.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vurtnewk.play.data.Article

/**
 * @author VurtneWk
 * 2021/10/18
 */
@BindingAdapter("articleItem")
fun setArticleItems(rv: RecyclerView, items: MutableList<Article>?) {
    items?.let {
        (rv.adapter as ArticleAdapter).submitList(items)
    }
}