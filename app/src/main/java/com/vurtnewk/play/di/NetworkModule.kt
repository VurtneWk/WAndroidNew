package com.vurtnewk.play.di

import com.vurtnewk.play.http.ApiService
import com.vurtnewk.play.http.HttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * @author VurtneWk
 * 2021/10/8
 */
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return HttpClient.mRetrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

}