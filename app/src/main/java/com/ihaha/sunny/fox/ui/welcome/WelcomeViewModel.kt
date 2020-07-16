package com.ihaha.sunny.fox.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.ihaha.sunny.base.viewModels.BaseViewModel
import com.ihaha.sunny.fox.domain.usecase.auth.AuthUseCase

class WelcomeViewModel(private val authUseCase: AuthUseCase) : BaseViewModel() {

    suspend fun getCurrentUser() : FirebaseUser? {
        return authUseCase.getCurrentUser()
    }

    suspend fun signInAnonymous(): LiveData<Task<AuthResult?>> {
        return authUseCase.signInAnonymous().asLiveData(viewModelScope.coroutineContext)
    }
}