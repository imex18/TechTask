package com.example.techtask.di

import com.example.techtask.data.AlbumsRepositoryImpl
import com.example.techtask.domain.AlbumsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class Dependencies {

    @Provides
    fun providesRepositoryInterface(repository: AlbumsRepositoryImpl): AlbumsRepository {
        return repository
    }
}