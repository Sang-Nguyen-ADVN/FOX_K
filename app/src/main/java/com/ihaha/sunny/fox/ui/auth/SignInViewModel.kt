package com.ihaha.sunny.fox.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.ihaha.sunny.base.viewModels.BaseViewModel
import com.ihaha.sunny.fox.domain.usecase.auth.AuthUseCase


/**
 * Create by Sunny date: 6/3/2020
 * Version: 1.0.0
 */
class SignInViewModel(private val authUseCase: AuthUseCase) : BaseViewModel() {

    suspend fun signInWithEmailAndPassword(email: String, password: String): LiveData<Task<AuthResult?>> {
        return authUseCase.signInWithEmailAndPassword(email, password).asLiveData(viewModelScope.coroutineContext)
    }

    suspend fun signInWithPhoneAndPassword(email: String, password: String): LiveData<Task<AuthResult?>> {
        return authUseCase.signInWithEmailAndPassword(email, password).asLiveData(viewModelScope.coroutineContext)
    }
}