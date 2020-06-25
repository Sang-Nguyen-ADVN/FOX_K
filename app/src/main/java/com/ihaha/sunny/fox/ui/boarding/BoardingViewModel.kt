package com.ihaha.sunny.fox.ui.boarding

import com.ihaha.sunny.base.viewModels.BaseViewModel
import com.ihaha.sunny.utils.prefs.SharePrefsManager

class BoardingViewModel(private val preferences: SharePrefsManager) : BaseViewModel(){
    fun saveKeyOnBoarding() = preferences.setCurrentBoarding(true)
}