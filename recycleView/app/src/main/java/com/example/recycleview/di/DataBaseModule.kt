package com.example.recycleview.di

import android.content.Context
import com.example.recycleview.data.dataBase.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
  //  @Provides
    //@Singleton
   // fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {}
}