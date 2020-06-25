package com.ihaha.sunny.fox.di

import com.ihaha.sunny.utils.prefs.SharePrefsApi
import com.ihaha.sunny.utils.settings.theme.ThemeUtilsImpl
import com.ihaha.sunny.utils.prefs.SharePrefsImpl
import com.ihaha.sunny.utils.prefs.SharePrefsManager
import com.ihaha.sunny.utils.settings.language.LanguageUtils
import com.ihaha.sunny.utils.settings.language.LanguageUtilsImpl
import com.ihaha.sunny.utils.settings.theme.ThemeUtils
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val settingModules = module {
    single<ThemeUtils> { ThemeUtilsImpl(androidContext()) }
    single<LanguageUtils> { LanguageUtilsImpl() }
    single { SharePrefsImpl(androidContext()) }
    single { SharePrefsManager(get()) }
}