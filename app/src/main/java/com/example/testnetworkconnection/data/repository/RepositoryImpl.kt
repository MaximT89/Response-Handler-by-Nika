package com.example.testnetworkconnection.data.repository

import com.example.testnetworkconnection.core.Result
import com.example.testnetworkconnection.data.api.ApiService
import com.example.testnetworkconnection.data.api.NetworkHelper
import com.example.testnetworkconnection.data.model.ResponseCat
import com.example.testnetworkconnection.domain.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val networkHelper: NetworkHelper
) : Repository {
    override suspend fun fetchData(): Result {
        return if (networkHelper.isNetworkConnected()) {
            Result.Success(apiService.fetchCatInfo())
        } else {
            Result.Error("Нет интернета")
        }

    }

}