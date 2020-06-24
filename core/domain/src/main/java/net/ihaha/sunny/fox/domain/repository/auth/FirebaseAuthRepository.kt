package net.ihaha.sunny.fox.domain.repository.auth

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import net.ihaha.sunny.base.domain.BaseRepository
import net.ihaha.sunny.base.network.remote.Resource

interface FirebaseAuthRepository : BaseRepository {

    suspend fun authStateChanges(): Flow<FirebaseAuth>

    suspend fun fetchProvidersForEmail(email: String): Flow<List<String>>

    suspend fun getCurrentUser(): Flow<FirebaseUser?>

    suspend fun sendPasswordResetEmail(email: String): Flow<Boolean>

    suspend fun signInAnonymous(): Flow<FirebaseUser?>

    suspend fun signInWithCredential(credential: AuthCredential): Flow<FirebaseUser?>

    suspend fun signInWithCustomToken(token: String): Flow<FirebaseUser?>

    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<FirebaseUser?>

    suspend fun signUpWithEmailAndPassword(email: String, password: String): Flow<FirebaseUser?>

    suspend fun signOut(): Flow<Boolean>
}