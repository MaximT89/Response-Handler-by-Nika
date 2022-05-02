package com.example.testnetworkconnection.core

sealed class Result{
    object Empty : Result()
    class Success<T>(val data : T): Result()
    class Error(val message: String) : Result()
}
