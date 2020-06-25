package com.ihaha.sunny.fox.organizations.di

import com.ihaha.sunny.fox.organizations.OriganizationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

private val domainModule = module {

}

private val viewModelModule = module {
    viewModel { OriganizationsViewModel() }
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
