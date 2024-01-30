package com.bbeniful.mviandcademo.di

import android.content.Context
import androidx.room.Room
import com.bbeniful.mviandcademo.core.data.database.dao.DemoDao
import com.bbeniful.mviandcademo.core.data.database.DemoDatabase
import com.bbeniful.mviandcademo.core.domain.repositories.DemoRepository
import com.bbeniful.mviandcademo.feature_add.domain.useCase.AddUseCase
import com.bbeniful.mviandcademo.feature_list.domain.useCase.ListDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): DemoDao {
        return Room.databaseBuilder(context, DemoDatabase::class.java, DemoDatabase.DATABASE_NAME)
            .build().dao()
    }

    @Provides
    fun provideListUseCase(repository: DemoRepository): ListDataUseCase {
        return ListDataUseCase(repository = repository)
    }

    @Provides
    fun provideAddUseCase(repository: DemoRepository): AddUseCase {
        return AddUseCase(repository = repository)
    }
}