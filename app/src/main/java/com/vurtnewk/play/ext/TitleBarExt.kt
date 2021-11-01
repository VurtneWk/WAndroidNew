package com.vurtnewk.play.ext

import android.app.Activity
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.vurtnewk.play.R

/**
 * @author VurtneWk
 * 2021/10/27
 */

fun Fragment.setTitle(
    title: String = "",
    @DrawableRes leftIcon: Int = R.drawable.ic_arrow_back_white,
    @DrawableRes rightIcon: Int? = null,
    leftClick: (() -> Unit)? = null
) {
    if (activity == null) {

    }
}