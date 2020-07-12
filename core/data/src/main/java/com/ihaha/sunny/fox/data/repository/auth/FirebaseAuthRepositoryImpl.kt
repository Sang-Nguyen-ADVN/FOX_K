package com.ihaha.sunny.fox.data.repository.auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.ihaha.sunny.base.exception.generateName
import com.ihaha.sunny.base.network.firebase.await
import com.ihaha.sunny.fox.domain.model.auth.User
import com.ihaha.sunny.fox.domain.repository.auth.FirebaseAuthRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

@ExperimentalCoroutinesApi
class FirebaseAuthRepositoryImpl(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseDatabase: FirebaseDatabase,
    private val firebaseStorage: FirebaseStorage
) : FirebaseAuthRepository {

    //region variable
    private val email: String? = null
    private val password: String? = null
    //endregion

    //region auth

    override suspend fun getCurrentUser() : FirebaseUser? {
        return firebaseAuth.currentUser
    }

    private val generateName = "".generateName()

    private val userId by lazy { firebaseAuth.currentUser?.uid }

    private val storageRef = firebaseStorage.getReference("${PATH_USERS}/$userId/$generateName")

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

    //endregion

    //region database



    override suspend fun updateInfoName(data: String?) = flow {
        emit(firebaseDatabase.getReference("${PATH_USERS}/${getCurrentUser()?.uid}")
            .child(CHILD_USER_NAME)
            .setValue(data))
    }

    override suspend fun updateInfoPhone(data: String?) = flow {
        emit(firebaseDatabase.getReference("${PATH_USERS}/${getCurrentUser()?.uid}")
            .child(CHILD_USER_PHONE)
            .setValue(data))
    }

    override suspend fun updateInfoBirth(data: Long?) = flow {
        emit(firebaseDatabase.getReference("${PATH_USERS}/${getCurrentUser()?.uid}")
            .child(CHILD_USER_BIRTH_DAY)
            .setValue(data))
    }

    override suspend fun updateInfoGender(data: String?) = flow {
        emit(firebaseDatabase.getReference("${PATH_USERS}/${getCurrentUser()?.uid}")
            .child(CHILD_USER_GENDER)
            .setValue(data))
    }

    override suspend fun updateUserData(user: User?) = flow {
        emit(firebaseDatabase.getReference("${PATH_USERS}/${getCurrentUser()?.uid}")
            .setValue(user))
    }

    override suspend fun getUsers() = flow {
        emit(firebaseDatabase.getReference(PATH_USERS))
    }

    override suspend fun getInfoUsers() = flow {
        emit(firebaseDatabase.getReference("${PATH_USERS}/${getCurrentUser()?.uid}"))
    }

//    override suspend fun updateUserAvatar(bytes: ByteArray?) =
//        storageRef.putBytes(bytes)
//            .addOnSuccessListener {
//                storageRef.downloadUrl.addOnSuccessListener {
//                    runBlocking {
//                        firebaseDatabase.getReference("${PATH_USERS}/${getCurrentUser()?.uid}")
//                            .child(CHILD_USER_AVATAR)
//                            .setValue(it)
//                    }
//                }
//            }

    //endregion

    companion object{
        const val PATH_USERS = "users"

        const val CHILD_USER_NAME = "userName"
        const val CHILD_USER_PHONE = "phone"
        const val CHILD_USER_BIRTH_DAY = "birthday"
        const val CHILD_USER_GENDER = "gender"
        const val CHILD_USER_AVATAR = "avatar"

        const val VALUE_USER_AVATAR = ""
    }
}