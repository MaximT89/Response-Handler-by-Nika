package com.example.testnetworkconnection.data.repository

import com.example.testnetworkconnection.core.Result
import com.example.testnetworkconnection.data.api.ApiService
import com.example.testnetworkconnection.data.api.NetworkHelper
import com.example.testnetworkconnection.data.api.ResponseHandler
import com.example.testnetworkconnection.data.model.ResponseCat
import com.example.testnetworkconnection.domain.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val responseHandler: ResponseHandler
) : Repository {

    override suspend fun fetchData(): Result {
        return responseHandler.handlerResponse {
            apiService.fetchCatInfo()
        }
    }
}