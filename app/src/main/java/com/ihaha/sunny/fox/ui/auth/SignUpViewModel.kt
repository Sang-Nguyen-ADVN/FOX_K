package com.ihaha.sunny.fox.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.ihaha.sunny.base.viewModels.BaseViewModel
import com.ihaha.sunny.fox.domain.usecase.auth.AuthUseCase

class SignUpViewModel(private val authUseCase: AuthUseCase) : BaseViewModel(){

    suspend fun signUpWithEmailAndPassword(email: String, password: String): LiveData<Task<AuthResult?>> {
        return authUseCase.signUpWithEmailAndPassword(email, password).asLiveData(viewModelScope.coroutineContext)
    }
}