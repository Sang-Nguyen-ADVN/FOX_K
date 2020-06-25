package com.ihaha.sunny.fox.domain.di

import com.google.firebase.auth.FirebaseAuth
import com.ihaha.sunny.fox.domain.usecase.auth.AuthUseCase
import org.koin.dsl.module

val domainModules = module {
    single { FirebaseAuth.getInstance() }
    factory { AuthUseCase(get()) }
}
