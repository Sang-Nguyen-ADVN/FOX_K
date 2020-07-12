package com.ihaha.sunny.fox.domain.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.ihaha.sunny.fox.domain.repository.home.NewestRepository
import com.ihaha.sunny.fox.domain.usecase.auth.AuthUseCase
import com.ihaha.sunny.fox.domain.usecase.home.NewestUseCase
import org.koin.dsl.module

val domainModules = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseDatabase.getInstance() }
    single { FirebaseStorage.getInstance() }
    factory { AuthUseCase(get()) }
    factory { NewestUseCase() }
}
