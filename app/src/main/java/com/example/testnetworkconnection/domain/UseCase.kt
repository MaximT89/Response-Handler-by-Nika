package com.example.testnetworkconnection.domain

interface UseCase<T> {

    suspend fun get() : T
}