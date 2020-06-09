package net.ihaha.sunny.fox.home.di

import net.ihaha.sunny.fox.home.HomeViewModel
import net.ihaha.sunny.fox.home.editors_choice.EditorsChoiceViewModel
import net.ihaha.sunny.fox.home.newest.NewestViewModel
import net.ihaha.sunny.fox.home.series.SeriesViewModel
import net.ihaha.sunny.fox.home.trending.TrendingViewModel
import net.ihaha.sunny.fox.home.video.VideoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


private val domainModule = module {

}

private val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { EditorsChoiceViewModel() }
    viewModel { NewestViewModel() }
    viewModel { SeriesViewModel() }
    viewModel { VideoViewModel() }
    viewModel { TrendingViewModel() }
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
