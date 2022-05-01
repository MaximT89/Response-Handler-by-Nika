package com.example.testnetworkconnection.di

import com.example.testnetworkconnection.data.model.ResponseCat
import com.example.testnetworkconnection.data.repository.RepositoryImpl
import com.example.testnetworkconnection.domain.CatsUseCase
import com.example.testnetworkconnection.domain.Repository
import com.example.testnetworkconnection.domain.UseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl) : Repository

    @Binds
    abstract fun bindUseCase(useCase: CatsUseCase) : UseCase<Response<ResponseCat>>


}