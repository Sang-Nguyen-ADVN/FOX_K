package com.ihaha.sunny.fox.domain.usecase.auth

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import com.ihaha.sunny.base.network.remote.Resource
import com.ihaha.sunny.fox.domain.repository.auth.FirebaseAuthRepository

class AuthUseCase(private val firebaseAuthRepository: FirebaseAuthRepository){

    suspend fun authStateChanges() : Flow<FirebaseAuth> = firebaseAuthRepository.authStateChanges()

    suspend fun fetchProvidersForEmail(email: String) : Flow<List<String>> = firebaseAuthRepository.fetchProvidersForEmail(email)

    suspend fun getCurrentUser() : Flow<FirebaseUser?> = firebaseAuthRepository.getCurrentUser()

    suspend fun sendPasswordResetEmail(email: String) : Flow<Boolean> = firebaseAuthRepository.sendPasswordResetEmail(email)

    suspend fun signInAnonymous() : Flow<FirebaseUser?> = firebaseAuthRepository.signInAnonymous()

    suspend fun signInWithCredential(credential: AuthCredential) : Flow<FirebaseUser?> = firebaseAuthRepository.signInWithCredential(credential)

    suspend fun signInWithCustomToken(token: String) : Flow<FirebaseUser?> = firebaseAuthRepository.signInWithCustomToken(token)

    suspend fun signInWithEmailAndPassword(email: String, password: String) : Flow<FirebaseUser?> = firebaseAuthRepository.signInWithEmailAndPassword(email, password)

    suspend fun signUpWithEmailAndPassword(email: String, password: String) : Flow<FirebaseUser?> = firebaseAuthRepository.signUpWithEmailAndPassword(email, password)

    suspend fun signOut()= firebaseAuthRepository.signOut()

}