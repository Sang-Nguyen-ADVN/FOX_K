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
class ResetPasswordViewModel(private val authUseCase: AuthUseCase) : BaseViewModel() {
    suspend fun sendEmailResetPassword(email: String): LiveData<Task<Void?>> {
        return authUseCase.sendEmailResetPassword(email).asLiveData(viewModelScope.coroutineContext)
    }
}