package com.ihaha.sunny.fox.di

import com.ihaha.sunny.fox.data.di.dataModule
import com.ihaha.sunny.fox.domain.di.domainModules
import com.ihaha.sunny.fox.local.di.databaseModule
import com.ihaha.sunny.fox.remote.di.networkModule
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single { androidApplication().resources }
}

val appModules = listOf(
    appModule,
    domainModules,
    networkModule,
    dataModule,
    viewModelModule,
    settingModules,
    databaseModule
)