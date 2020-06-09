package net.ihaha.sunny.fox.domain.usecase.firebase

import com.google.firebase.auth.AuthCredential
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import net.ihaha.sunny.base.domain.BaseUseCase
import net.ihaha.sunny.fox.data.repository.auth.FirebaseAuthRepository

class FirebaseAuthUseCase(private val firebaseAuthRepository: FirebaseAuthRepository){

    suspend fun authStateChanges() = firebaseAuthRepository.authStateChanges()

    suspend fun createUserWithEmailAndPassword(email: String, password: String) = firebaseAuthRepository.createUserWithEmailAndPassword(email, password)

    suspend fun fetchProvidersForEmail(email: String) = firebaseAuthRepository.fetchProvidersForEmail(email)

    suspend fun getCurrentUser() = firebaseAuthRepository.getCurrentUser()

    suspend fun sendPasswordResetEmail(email: String) = firebaseAuthRepository.sendPasswordResetEmail(email)

    suspend fun signInAnonymous() = firebaseAuthRepository.signInAnonymous()

    suspend fun signInWithCredential(credential: AuthCredential) = firebaseAuthRepository.signInWithCredential(credential)

    suspend fun signInWithCustomToken(token: String) = firebaseAuthRepository.signInWithCustomToken(token)

    suspend fun signInWithEmailAndPassword(email: String, password: String) = firebaseAuthRepository.signInWithEmailAndPassword(email, password)

    suspend fun signUpWithEmailAndPassword(email: String, password: String) = firebaseAuthRepository.signUpWithEmailAndPassword(email, password)

    suspend fun signOut()= firebaseAuthRepository.signOut()

}