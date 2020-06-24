package net.ihaha.sunny.fox.ui.boarding

import net.ihaha.sunny.base.viewModels.BaseViewModel
import net.ihaha.sunny.utils.prefs.SharePrefsManager

class BoardingViewModel(private val preferences: SharePrefsManager) : BaseViewModel(){
    fun saveKeyOnBoarding() = preferences.setCurrentBoarding(true)
}