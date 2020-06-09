package net.ihaha.sunny.fox.data.repository.auth

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import net.ihaha.sunny.base.network.firebase.await

class FirebaseAuthRepositoryImpl(private val firebaseAuth: FirebaseAuth) : FirebaseAuthRepository {

    @ExperimentalCoroutinesApi
    override suspend fun authStateChanges() = callbackFlow<FirebaseAuth>  {
        val listener = FirebaseAuth.AuthStateListener {
            this@callbackFlow.sendBlocking(it)
        }
        firebaseAuth.addAuthStateListener(listener)

        awaitClose {
            firebaseAuth.removeAuthStateListener(listener)
        }
    }

    override suspend fun createUserWithEmailAndPassword(email: String, password: String) = flow{
        emit(firebaseAuth.signInWithEmailAndPassword(email, password).await())
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

    override suspend fun sendPasswordResetEmail(email: String) = flow {
        firebaseAuth.sendPasswordResetEmail(email).await()
        emit(true)
    }

    override suspend fun signInAnonymous() = flow {
        val auth = firebaseAuth.signInAnonymously().await()
        emit(auth.user)
    }

    override suspend fun signInWithCredential(credential: AuthCredential) = flow {
        val auth = firebaseAuth.signInWithCredential(credential).await()
        emit(auth.user)
    }

    override suspend fun signInWithCustomToken(token: String) = flow {
        val auth = firebaseAuth.signInWithCustomToken(token).await()
        emit(auth.user)
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String) = flow {
        val auth = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        emit(auth.user)
    }

    override suspend fun signUpWithEmailAndPassword(email: String, password: String) = flow {
        val auth = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        emit(auth.user)
    }

    override suspend fun signOut() = flow {
        firebaseAuth.signOut()
        emit(true)
    }

}