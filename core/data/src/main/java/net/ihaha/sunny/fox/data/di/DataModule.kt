package net.ihaha.sunny.fox.data.di

import android.content.Context
import androidx.room.Room
import net.ihaha.sunny.fox.data.repository.auth.FirebaseAuthRepositoryImpl
import net.ihaha.sunny.fox.domain.repository.auth.FirebaseAuthRepository
import net.ihaha.sunny.fox.local.AppDatabase
import net.ihaha.sunny.fox.local.BuildConfig
import org.koin.dsl.module

val dataModule = module {
    single { createDatabaseName() }

    factory<FirebaseAuthRepository> { FirebaseAuthRepositoryImpl(get()) }

}

fun createDatabaseName() = BuildConfig.FOX_DATABASE_NAME

fun createAppDatabase(dbName: String, context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, dbName).build()



//fun createMovieDao(appDatabase: AppDatabase) = appDatabase.movieDao()
