package com.example.testnetworkconnection.data.api

import com.example.testnetworkconnection.core.Result
import retrofit2.Response
import javax.inject.Inject

interface ResponseHandler {

    suspend fun <T> handlerResponse(
        apiCall: suspend () ->
        Response<T>,
    ): Result

    class Base @Inject constructor(private val networkHelper: NetworkHelper) : ResponseHandler {
        override suspend fun <T> handlerResponse(apiCall: suspend () -> Response<T>): Result {
            if (networkHelper.isNetworkConnected()) {
                try {
                    val response = apiCall()
                    val body = response.body()
                    if (response.isSuccessful && body != null) {
                        return Result.Success(response)
                    }
                    return Result.Error(response.errorBody().toString())
                } catch (e : Exception){
                    return Result.Error(e.printStackTrace().toString())
                }
            } else {
                return Result.Error("No internet connection")
            }
        }
    }
}