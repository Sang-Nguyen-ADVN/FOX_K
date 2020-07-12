package com.ihaha.sunny.fox.domain.usecase.auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.ihaha.sunny.fox.domain.model.auth.User
import kotlinx.coroutines.flow.Flow
import com.ihaha.sunny.fox.domain.repository.auth.FirebaseAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthUseCase(private val firebaseAuthRepository: FirebaseAuthRepository) {

    suspend fun authStateChanges(): Flow<FirebaseAuth> =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.authStateChanges()
        }

    suspend fun fetchProvidersForEmail(email: String): Flow<List<String>> =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.fetchProvidersForEmail(email)
        }

    suspend fun getCurrentUser(): FirebaseUser? =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.getCurrentUser()
        }

    suspend fun sendEmailResetPassword(email: String): Flow<Task<Void?>> =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.sendEmailResetPassword(email)
        }

    suspend fun signInAnonymous(): Flow<Task<AuthResult?>> =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.signInAnonymous()
        }

    suspend fun signInWithCredential(credential: AuthCredential): Flow<Task<AuthResult?>> =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.signInWithCredential(credential)
        }

    suspend fun signInWithCustomToken(token: String): Flow<Task<AuthResult?>> =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.signInWithCustomToken(token)
        }

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<Task<AuthResult?>> =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.signInWithEmailAndPassword(email, password)
        }

    suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<Task<AuthResult?>> = withContext(Dispatchers.IO) {
        firebaseAuthRepository.signUpWithEmailAndPassword(email, password)
    }

    suspend fun signOut() = withContext(Dispatchers.IO) {
        firebaseAuthRepository.signOut()
    }

    suspend fun updateInfoName(data: String?) =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.updateInfoName(data)
        }

    suspend fun updateInfoPhone(data: String?) =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.updateInfoPhone(data)
        }

    suspend fun updateInfoBirth(data: Long?) =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.updateInfoBirth(data)
        }

    suspend fun updateInfoGender(data: String?) =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.updateInfoPhone(data)
        }

    suspend fun updateUserData(user: User?) =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.updateUserData(user)
        }

    suspend fun getUsers(): Flow<DatabaseReference?> =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.getUsers()
        }

    suspend fun getInfoUsers() =
        withContext(Dispatchers.IO) {
            firebaseAuthRepository.getInfoUsers()
        }

}