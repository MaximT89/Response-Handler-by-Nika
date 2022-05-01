package com.example.testnetworkconnection.domain

import com.example.testnetworkconnection.core.Result
import com.example.testnetworkconnection.data.model.ResponseCat
import retrofit2.Response

interface Repository {

    suspend fun fetchData() : Result
}