package com.example.testnetworkconnection.data.api

import com.example.testnetworkconnection.data.model.ResponseCat
import com.example.testnetworkconnection.data.model.ResponseDog
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("woof.json")
    suspend fun fetchCatInfo() : Response<ResponseDog>

}