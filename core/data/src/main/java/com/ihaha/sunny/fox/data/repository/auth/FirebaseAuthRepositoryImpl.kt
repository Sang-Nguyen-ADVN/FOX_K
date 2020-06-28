package com.ihaha.sunny.fox.data.repository.auth

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import com.ihaha.sunny.base.network.firebase.await
import com.ihaha.sunny.base.network.resource.NetworkBoundResourceNoCache
import com.ihaha.sunny.base.network.resource.networkBoundResourceNoCacheLazy
import com.ihaha.sunny.fox.domain.repository.auth.FirebaseAuthRepository
import com.ihaha.sunny.fox.domain.viewstate.AuthViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.withContext
import okhttp3.internal.wait

@ExperimentalCoroutinesApi
class FirebaseAuthRepositoryImpl(private val firebaseAuth: FirebaseAuth) :
    FirebaseAuthRepository {

    //region variable
    private val email: String? = null
    private val password: String? = null
    //endregion

    override suspend fun authStateChanges() = callbackFlow<FirebaseAuth> {
        val listener = FirebaseAuth.AuthStateListener {
            this@callbackFlow.sendBlocking(it)
        }
        firebaseAuth.addAuthStateListener(listener)

        awaitClose {
            firebaseAuth.removeAuthStateListener(listener)
        }
    }

    override suspend fun fetchProvidersForEmail(email: String?) = flow {
        val auth = firebaseAuth.fetchSignInMethodsForEmail(email.toString()).await()
        (auth.signInMethods ?: ArrayList()).apply {
            emit(this)
        }
    }

    override suspend fun getCurrentUser() = flow {
        emit(firebaseAuth.currentUser)
    }

    override suspend fun signInAnonymous() = flow {
        emit(firebaseAuth.signInAnonymously())
    }

    override suspend fun signInWithCredential(credential: AuthCredential) = flow {
        emit(firebaseAuth.signInWithCredential(credential))
    }

    override suspend fun signInWithCustomToken(token: String?) = flow {
        emit(firebaseAuth.signInWithCustomToken(token.toString()))
    }

    override suspend fun signInWithEmailAndPassword(email: String?, password: String?) = flow {
        emit(firebaseAuth.signInWithEmailAndPassword(email.toString(), password.toString()))
    }

//    override suspend fun signInWithPhoneAndPassword(phone: String?, password: String?) = flow {
//        emit(firebaseAuth.signin(email.toString(), password.toString()))
//    }

    override suspend fun signUpWithEmailAndPassword(email: String?, password: String?) = flow {
        emit(firebaseAuth.createUserWithEmailAndPassword(email.toString(), password.toString()))
    }

    override suspend fun sendEmailResetPassword(email: String?) = flow {
        emit(firebaseAuth.sendPasswordResetEmail(email.toString()))
    }

    override suspend fun signOut() = flow {
        firebaseAuth.signOut()
        emit(true)
    }


}