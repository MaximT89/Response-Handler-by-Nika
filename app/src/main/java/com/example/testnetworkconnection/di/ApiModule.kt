package com.example.testnetworkconnection.di

import android.content.Context
import com.example.testnetworkconnection.data.api.ApiService
import com.example.testnetworkconnection.data.api.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = "https://cat-fact.herokuapp.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl : String) : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideNetworkHelper(@ApplicationContext context : Context) = NetworkHelper(context)
}