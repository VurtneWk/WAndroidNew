package com.vurtnewk.android.initializer

import android.content.Context
import androidx.startup.Initializer
import com.tencent.mmkv.MMKV

/**
 * @author VurtneWk
 * 2021/9/29
 */
@Suppress("unused")
class MMKVInitializer : Initializer<MMKV> {

    override fun create(context: Context): MMKV {
        MMKV.initialize(context)
        return MMKV.defaultMMKV()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()


}