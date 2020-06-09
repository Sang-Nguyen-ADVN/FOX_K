package net.ihaha.sunny.fox.login.di

import net.ihaha.sunny.fox.login.ResetPasswordViewModel
import net.ihaha.sunny.fox.login.SignInViewModel
import net.ihaha.sunny.fox.login.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


/**
 * Create by Sunny date: 6/5/2020
 * Version: 1.0.0
 */
private val domainModule = module {

}

private val viewModelModule = module {
    viewModel { SignInViewModel() }
    viewModel { SignUpViewModel() }
    viewModel { ResetPasswordViewModel() }
}

private val repositoriesModule = module {

}

private val presentationModule = module {

}

fun injectFeature() = loadFeature

fun removeFeature() = unLoadFeature

private val loadFeature by lazy { load() }

private val unLoadFeature by lazy { unLoad() }

private fun load() =
    loadKoinModules(listOf(domainModule, viewModelModule, repositoriesModule, presentationModule))

private fun unLoad() =
    loadKoinModules(listOf(domainModule, viewModelModule, repositoriesModule, presentationModule))