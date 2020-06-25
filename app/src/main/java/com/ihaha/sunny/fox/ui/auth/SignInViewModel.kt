package com.ihaha.sunny.fox.ui.auth

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.ihaha.sunny.base.exception.invalidEmail
import com.ihaha.sunny.base.exception.invalidPassword
import com.ihaha.sunny.base.viewModels.BaseViewModel
import com.ihaha.sunny.fox.domain.usecase.auth.AuthUseCase


/**
 * Create by Sunny date: 6/3/2020
 * Version: 1.0.0
 */
class SignInViewModel(private val authUseCase: AuthUseCase) : BaseViewModel() {

    fun signInWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        if(email.invalidEmail() && password.invalidPassword()) {
            authUseCase.signInWithEmailAndPassword(email, password).asLiveData(viewModelScope.coroutineContext)
        }
    }
}