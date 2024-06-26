package com.example.recycleview.di

import android.content.Context
import androidx.room.Room
import com.example.recycleview.data.dataBase.AppDataBase
import com.example.recycleview.data.dataBase.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "aula")
            .fallbackToDestructiveMigration().build()
    }
    @Provides
    @Singleton
    fun provideProductDaoService(appDataBase: AppDataBase): ProductDao{
        return appDataBase.productDao()
    }
}