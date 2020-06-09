package net.ihaha.sunny.fox.ui.splash

import net.ihaha.sunny.base.viewModels.BaseViewModel
import net.ihaha.sunny.fox.domain.usecase.firebase.FirebaseAuthUseCase
import net.ihaha.sunny.utils.prefs.SharePrefsManager

class SplashViewModel(private val preferences: SharePrefsManager,
                      private val firebaseAuthUseCase: FirebaseAuthUseCase) : BaseViewModel(){
    fun isCheckOnBoarding() : Boolean = preferences.getOnBoarding() ?: false

    suspend fun signInWithEmailAndPassword(email: String, password: String){
        firebaseAuthUseCase.signInWithEmailAndPassword(email, password)
    }

}