package com.ihaha.sunny.fox

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import androidx.multidex.MultiDex
import com.google.firebase.FirebaseApp
import com.ihaha.sunny.fox.di.appModules
import com.ihaha.sunny.utils.prefs.SharePrefsManager
import com.ihaha.sunny.utils.prefs.SharedPrefKeys
import com.ihaha.sunny.utils.settings.language.LanguageUtils
import com.ihaha.sunny.utils.settings.language.LanguageUtilsImpl
import com.ihaha.sunny.utils.settings.theme.ThemeUtils
import com.ihaha.sunny.utils.settings.theme.ThemeUtilsImpl
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.logger.Level.*
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE
import timber.log.Timber

/**
 * Created by Sunny on 3/13/2020.
 * Version 1.0
 */

class AppApplication : Application() {

    private val themeUtils: ThemeUtils by inject()
    private val languageUtils: LanguageUtils by inject()
    private val sharePrefsManager: SharePrefsManager by inject()

    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)
        FirebaseApp.initializeApp(this)

        startKoin {
            logger(object : Logger(DEBUG) {
                override fun log(
                    level: Level,
                    msg: MESSAGE
                ) {
                    when (level) {
                        DEBUG -> Timber.d(msg)
                        INFO -> Timber.i(msg)
                        ERROR -> Timber.e(msg)
                        NONE -> {
                        }
                    }
                }
            })
            androidContext(this@AppApplication)
            modules(appModules)
        }

//        initTheme()
    }

//    override fun attachBaseContext(content: Context?) {
//        super.attachBaseContext(content?.let { initLanguage(content) });
//    }

    private fun initTheme() {
        val theme = sharePrefsManager.getTheme()
        if (theme != null) {
            if (theme == SharedPrefKeys.Theme.LIGHT_MODE)
                themeUtils.setNightMode(false)
            else
                themeUtils.setNightMode(true)
        } else {
            sharePrefsManager.setTheme(SharedPrefKeys.Theme.LIGHT_MODE)
            themeUtils.setNightMode(false)
        }
    }

    private fun initLanguage(context: Context): Context? {
        val language = sharePrefsManager.getLanguage()
        return if (language != null) {
            if (language == SharedPrefKeys.Language.VIETNAMESE)
                languageUtils.setLanguage(SharedPrefKeys.Language.VIETNAMESE)
            else
                languageUtils.setLanguage(SharedPrefKeys.Language.ENGLISH)
        } else {
            sharePrefsManager.setTheme(SharedPrefKeys.Language.VIETNAMESE)
            languageUtils.setLanguage(SharedPrefKeys.Language.VIETNAMESE)
        }
    }

}