package net.ihaha.sunny.fox.domain.di

import com.google.firebase.auth.FirebaseAuth
import net.ihaha.sunny.fox.data.repository.auth.FirebaseAuthRepository
import net.ihaha.sunny.fox.data.repository.auth.FirebaseAuthRepositoryImpl
import net.ihaha.sunny.fox.domain.usecase.firebase.FirebaseAuthUseCase
import org.koin.dsl.module

val domainModules = module {
    single { FirebaseAuth.getInstance() }
    single <FirebaseAuthRepository> { FirebaseAuthRepositoryImpl(get()) }
    single { FirebaseAuthUseCase(get()) }
}
