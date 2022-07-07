package com.example.techtask.di

import android.app.Application
import android.content.Context
import com.example.techtask.data.AlbumsRepositoryImpl
import com.example.techtask.domain.repository.AlbumsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun providesRepositoryInterface(repository: AlbumsRepositoryImpl): AlbumsRepository {
        return repository
    }
}

@Module
@InstallIn(SingletonComponent::class)
class Context {
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}
