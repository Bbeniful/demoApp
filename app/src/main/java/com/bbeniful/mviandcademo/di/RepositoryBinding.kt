package com.bbeniful.mviandcademo.di

import com.bbeniful.mviandcademo.DemoRepository
import com.bbeniful.mviandcademo.DemoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryBinding {

    @Binds
    abstract fun bindRepository(
        demoRepositoryImpl: DemoRepositoryImpl
    ): DemoRepository
}