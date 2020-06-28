package com.ihaha.sunny.fox.data.di

import android.content.Context
import androidx.room.Room
import com.ihaha.sunny.fox.data.repository.auth.FirebaseAuthRepositoryImpl
import com.ihaha.sunny.fox.data.repository.home.NewestRepositoryImpl
import com.ihaha.sunny.fox.domain.repository.auth.FirebaseAuthRepository
import com.ihaha.sunny.fox.domain.repository.home.NewestRepository
import com.ihaha.sunny.fox.local.AppDatabase
import com.ihaha.sunny.fox.local.BuildConfig
import org.koin.dsl.module

val dataModule = module {
    single { createDatabaseName() }

    factory<FirebaseAuthRepository> { FirebaseAuthRepositoryImpl(get()) }
    factory<NewestRepository> { NewestRepositoryImpl(get(), get(), get()) }

}

fun createDatabaseName() = BuildConfig.FOX_DATABASE_NAME

fun createAppDatabase(dbName: String, context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, dbName).build()



//fun createMovieDao(appDatabase: AppDatabase) = appDatabase.movieDao()
