package com.example.recycleview.di

import com.example.recycleview.data.dataBase.ProductDao
import com.example.recycleview.data.dataSources.ProductDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideProductDataSource(productDao: ProductDao): ProductDataSource {
        return ProductDataSource(productDao)
    }
}