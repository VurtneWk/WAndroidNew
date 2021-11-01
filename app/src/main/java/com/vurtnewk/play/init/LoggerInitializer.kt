package com.vurtnewk.android.initializer

import android.content.Context
import androidx.startup.Initializer
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

import com.orhanobut.logger.FormatStrategy


/**
 * @author VurtneWk
 * 2021/9/30
 */
@Suppress("unused")
class LoggerInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false) // (Optional) Whether to show thread info or not. Default true
//            .methodCount(0) // (Optional) How many method line to show. Default 2
//            .methodOffset(7) // (Optional) Hides internal method calls up to offset. Default 5
//            .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
            .tag("WAndroidNew") // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}