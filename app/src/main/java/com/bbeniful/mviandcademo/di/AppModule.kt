package com.bbeniful.mviandcademo.di

import android.content.Context
import androidx.room.Room
import com.bbeniful.mviandcademo.DemoDao
import com.bbeniful.mviandcademo.DemoDatabase
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
}