package com.example.clean_architecture_study.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.example.data.datastore.LikeList
import com.example.data.source.local.LikeSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {
    @Provides
    @Singleton
    fun provideLikeDataStore(@ApplicationContext context: Context): DataStore<LikeList> {
        return DataStoreFactory.create(
            serializer = LikeSerializer,
            produceFile = { context.dataStoreFile("like.pb") }
        )
    }
}