package net.ihaha.sunny.fox.di

import net.ihaha.sunny.utils.prefs.SharePrefsApi
import net.ihaha.sunny.utils.settings.theme.ThemeUtilsImpl
import net.ihaha.sunny.utils.prefs.SharePrefsImpl
import net.ihaha.sunny.utils.prefs.SharePrefsManager
import net.ihaha.sunny.utils.settings.language.LanguageUtils
import net.ihaha.sunny.utils.settings.language.LanguageUtilsImpl
import net.ihaha.sunny.utils.settings.theme.ThemeUtils
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val settingModules = module {
    single<ThemeUtils> { ThemeUtilsImpl(androidContext()) }
    single<LanguageUtils> { LanguageUtilsImpl() }
    single { SharePrefsImpl(androidContext()) }
    single { SharePrefsManager(get()) }
}