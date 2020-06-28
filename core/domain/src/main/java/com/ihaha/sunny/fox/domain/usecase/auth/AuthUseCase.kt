package com.ihaha.sunny.fox.domain.usecase.auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import com.ihaha.sunny.fox.domain.repository.auth.FirebaseAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthUseCase(private val firebaseAuthRepository: FirebaseAuthRepository){

    suspend fun authStateChanges() : Flow<FirebaseAuth> = firebaseAuthRepository.authStateChanges()

    suspend fun fetchProvidersForEmail(email: String) : Flow<List<String>> = firebaseAuthRepository.fetchProvidersForEmail(email)

    suspend fun getCurrentUser() : Flow<FirebaseUser?> = firebaseAuthRepository.getCurrentUser()

    suspend fun sendEmailResetPassword(email: String) : Flow<Task<Void?>> = firebaseAuthRepository.sendEmailResetPassword(email)

    suspend fun signInAnonymous() : Flow<Task<AuthResult?>> = firebaseAuthRepository.signInAnonymous()

    suspend fun signInWithCredential(credential: AuthCredential) : Flow<Task<AuthResult?>> = firebaseAuthRepository.signInWithCredential(credential)

    suspend fun signInWithCustomToken(token: String) : Flow<Task<AuthResult?>> = firebaseAuthRepository.signInWithCustomToken(token)

    suspend fun signInWithEmailAndPassword(email: String, password: String) : Flow<Task<AuthResult?>> = withContext(Dispatchers.IO) {
        firebaseAuthRepository.signInWithEmailAndPassword(email, password)
    }

    suspend fun signUpWithEmailAndPassword(email: String, password: String) : Flow<Task<AuthResult?>> = firebaseAuthRepository.signUpWithEmailAndPassword(email, password)

    suspend fun signOut()= firebaseAuthRepository.signOut()

}