package com.vurtnewk.play.http

import com.vurtnewk.play.BuildConfig
import com.vurtnewk.play.constants.WConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpClient {

    val mRetrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl(WConstants.BASE_URL)
            .client(getOKHttpClient()) //retrofit 默认应该也用的okHttp
            //By default, Retrofit can only deserialize HTTP bodies into OkHttp's ResponseBody type
            // and it can only accept its RequestBody type for @Body.
//            .addCallAdapterFactory(GsonConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())//JSON转换.kotlin使用moshi
            .build()
    }

    private fun getOKHttpClient(): OkHttpClient {
        val newBuilder = OkHttpClient().newBuilder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        newBuilder.apply {
            addInterceptor(httpLoggingInterceptor)
        }
        return newBuilder.build()
    }

    fun <T> create(service: Class<T>): T {
        return mRetrofit.create(service)
    }
}