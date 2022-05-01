package com.example.testnetworkconnection.domain

import com.example.testnetworkconnection.data.model.ResponseCat
import retrofit2.Response
import javax.inject.Inject

class CatsUseCase @Inject constructor(
    private val repository: Repository,
) : UseCase<Response<ResponseCat>> {
    override suspend fun get(): Response<ResponseCat> {
        return repository.fetchData()
    }
}