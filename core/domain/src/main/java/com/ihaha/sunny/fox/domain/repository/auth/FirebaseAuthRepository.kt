package com.ihaha.sunny.fox.domain.repository.auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.flow.Flow
import com.ihaha.sunny.base.domain.BaseRepository
import com.ihaha.sunny.fox.domain.model.auth.User

interface FirebaseAuthRepository : BaseRepository {

    suspend fun authStateChanges(): Flow<FirebaseAuth>

    suspend fun fetchProvidersForEmail(email: String?): Flow<List<String>>

    suspend fun getCurrentUser(): FirebaseUser?

    suspend fun sendEmailResetPassword(email: String?): Flow<Task<Void?>>

    suspend fun signInAnonymous(): Flow<Task<AuthResult?>>

    suspend fun signInWithCredential(credential: AuthCredential): Flow<Task<AuthResult?>>

    suspend fun signInWithCustomToken(token: String?): Flow<Task<AuthResult?>>

    suspend fun signInWithEmailAndPassword(email: String?, password: String?): Flow<Task<AuthResult?>>

    suspend fun signUpWithEmailAndPassword(email: String?, password: String?): Flow<Task<AuthResult?>>

    suspend fun signOut(): Flow<Boolean>

    suspend fun updateUserData(user: User?) : Flow<Task<Void?>>

    suspend fun updateInfoName(data: String?) : Flow<Task<Void?>>

    suspend fun updateInfoPhone(data: String?) : Flow<Task<Void?>>

    suspend fun updateInfoBirth(data: Long?): Flow<Task<Void?>>

    suspend fun updateInfoGender(data: String?): Flow<Task<Void?>>

    suspend fun getUsers(): Flow<DatabaseReference?>

    suspend fun getInfoUsers() : Flow<DatabaseReference?>



}