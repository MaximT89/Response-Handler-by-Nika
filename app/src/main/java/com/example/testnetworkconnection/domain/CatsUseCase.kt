package com.example.testnetworkconnection.domain

import com.example.testnetworkconnection.core.Result
import com.example.testnetworkconnection.data.model.ResponseCat
import retrofit2.Response
import javax.inject.Inject

class CatsUseCase @Inject constructor(
    private val repository: Repository,
) : UseCase<Result> {
    override suspend fun get(): Result {
        return repository.fetchData()
    }

}