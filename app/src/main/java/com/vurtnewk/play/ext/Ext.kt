package com.vurtnewk.play.ext

import android.view.View

/**
 * @author VurtneWk
 * 2021/10/8
 */
fun View.setNoFastClickListener(interval: Int = 800, block: () -> Unit) {
    setOnClickListener {
        val lastClickTime = tag
        val time = lastClickTime as? Long
        if (time == null) {
            block.invoke()
            tag = System.currentTimeMillis()
        } else {
            if (System.currentTimeMillis() - time > interval) {
                block.invoke()
                tag = System.currentTimeMillis()
            }
        }
    }
}
