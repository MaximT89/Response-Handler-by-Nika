package com.example.testnetworkconnection.data.api

import com.example.testnetworkconnection.data.model.ResponseCat
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/facts/random")
    suspend fun fetchCatInfo() : Response<ResponseCat>

}