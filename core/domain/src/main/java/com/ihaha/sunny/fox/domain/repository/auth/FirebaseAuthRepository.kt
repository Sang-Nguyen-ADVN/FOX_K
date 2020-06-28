package com.ihaha.sunny.fox.domain.repository.auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import com.ihaha.sunny.base.domain.BaseRepository

interface FirebaseAuthRepository : BaseRepository {

    suspend fun authStateChanges(): Flow<FirebaseAuth>

    suspend fun fetchProvidersForEmail(email: String?): Flow<List<String>>

    suspend fun getCurrentUser(): Flow<FirebaseUser?>

    suspend fun sendEmailResetPassword(email: String?): Flow<Task<Void?>>

    suspend fun signInAnonymous(): Flow<Task<AuthResult?>>

    suspend fun signInWithCredential(credential: AuthCredential): Flow<Task<AuthResult?>>

    suspend fun signInWithCustomToken(token: String?): Flow<Task<AuthResult?>>

    suspend fun signInWithEmailAndPassword(email: String?, password: String?): Flow<Task<AuthResult?>>

    suspend fun signUpWithEmailAndPassword(email: String?, password: String?): Flow<Task<AuthResult?>>

    suspend fun signOut(): Flow<Boolean>
}