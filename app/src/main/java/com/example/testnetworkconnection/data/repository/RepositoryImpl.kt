package com.example.testnetworkconnection.data.repository

import com.example.testnetworkconnection.data.api.ApiService
import com.example.testnetworkconnection.data.model.ResponseCat
import com.example.testnetworkconnection.domain.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : Repository {
    override suspend fun fetchData(): Response<ResponseCat> {
        return apiService.fetchCatInfo()
    }

}