package net.ihaha.sunny.utils.prefs

class SharePrefsManager(private val sharePreferences: SharePrefsImpl?) {

    val TAG = SharePrefsManager::class.java.simpleName

    fun setCurrentBoarding(isSave: Boolean) = sharePreferences?.put(SharedPrefKeys.Welcome.ON_CURRENT_USER_KEY, isSave)

    fun getCurrentBoarding() : Boolean? = sharePreferences?.get(SharedPrefKeys.Welcome.ON_CURRENT_USER_KEY, Boolean::class.java)

    fun setTheme(theme: String) = sharePreferences?.put(SharedPrefKeys.Theme.THEME, theme)

    fun getTheme() : String? = sharePreferences?.get(SharedPrefKeys.Theme.THEME, String::class.java)

    fun setLanguage(language: String) = sharePreferences?.put(SharedPrefKeys.Language.LANGUAGE, language)

    fun getLanguage() : String? = sharePreferences?.get(SharedPrefKeys.Language.LANGUAGE, String::class.java)

}