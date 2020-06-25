package com.ihaha.sunny.fox.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.ihaha.sunny.base.viewModels.BaseViewModel
import com.ihaha.sunny.fox.domain.usecase.auth.AuthUseCase
import com.ihaha.sunny.utils.prefs.SharePrefsManager

class SplashViewModel(
    private val preferences: SharePrefsManager,
    private val authUseCase: AuthUseCase
) : BaseViewModel() {

    fun isCurrentBoarding(): Boolean = preferences.getCurrentBoarding() ?: false

}