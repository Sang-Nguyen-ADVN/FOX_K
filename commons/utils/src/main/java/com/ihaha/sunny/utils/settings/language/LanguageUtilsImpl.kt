package com.ihaha.sunny.utils.settings.language

import android.content.Context
import java.util.*

class LanguageUtilsImpl() : LanguageUtils {

    fun setLanguage(context: Context?, lang: String) : Context? {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val resource = context?.resources
        val configuration = resource?.configuration
        configuration?.setLocale(locale)
//        resource?.updateConfiguration(configuration, resource.displayMetrics)
        return context
    }

    override fun setLanguage(lang: String): Context? {
        TODO("Not yet implemented")
    }
}