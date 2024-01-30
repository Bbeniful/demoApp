package com.bbeniful.mviandcademo.di

import com.bbeniful.mviandcademo.core.domain.repositories.DemoRepository
import com.bbeniful.mviandcademo.core.data.repositories.DemoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBinding {

    @Binds
    @Singleton
    abstract fun bindRepository(
        demoRepositoryImpl: DemoRepositoryImpl
    ): DemoRepository
}