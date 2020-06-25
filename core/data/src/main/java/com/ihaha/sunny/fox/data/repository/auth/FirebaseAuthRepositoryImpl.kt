package com.ihaha.sunny.fox.data.repository.auth

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import com.ihaha.sunny.base.network.firebase.await
import com.ihaha.sunny.fox.domain.repository.auth.FirebaseAuthRepository

class FirebaseAuthRepositoryImpl(private val firebaseAuth: FirebaseAuth) :
    FirebaseAuthRepository {

    @ExperimentalCoroutinesApi
    override suspend fun authStateChanges()= callbackFlow<FirebaseAuth>  {
        val listener = FirebaseAuth.AuthStateListener {
            this@callbackFlow.sendBlocking(it)
        }
        firebaseAuth.addAuthStateListener(listener)

        awaitClose {
            firebaseAuth.removeAuthStateListener(listener)
        }
    }

    override suspend fun fetchProvidersForEmail(email: String) = flow {
        val auth = firebaseAuth.fetchSignInMethodsForEmail(email).await()
        (auth.signInMethods ?: ArrayList()).apply {
            emit(this)
        }
    }

    override suspend fun getCurrentUser() = flow{
        emit(firebaseAuth.currentUser)
    }

    override suspend fun signInAnonymous() = flow {
        emit(firebaseAuth.signInAnonymously().await().user)
    }

    override suspend fun signInWithCredential(credential: AuthCredential) = flow {
        emit(firebaseAuth.signInWithCredential(credential).await().user)
    }

    override suspend fun signInWithCustomToken(token: String) = flow {
        emit(firebaseAuth.signInWithCustomToken(token).await().user)
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String) = flow {
        emit(firebaseAuth.signInWithEmailAndPassword(email, password).await().user)
    }

    override suspend fun signUpWithEmailAndPassword(email: String, password: String) = flow {
        emit(firebaseAuth.createUserWithEmailAndPassword(email, password).await().user)
    }

    override suspend fun sendPasswordResetEmail(email: String) = flow {
        firebaseAuth.sendPasswordResetEmail(email).await()
        emit(true)
    }

    override suspend fun signOut() = flow {
        firebaseAuth.signOut()
        emit(true)
    }

}