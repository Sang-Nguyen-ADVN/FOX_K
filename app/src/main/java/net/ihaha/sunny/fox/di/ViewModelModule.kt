package net.ihaha.sunny.fox.di

import net.ihaha.sunny.fox.domain.usecase.firebase.FirebaseAuthUseCase
import net.ihaha.sunny.fox.ui.boarding.BoardingViewModel
import net.ihaha.sunny.fox.ui.main.MainViewModel
import net.ihaha.sunny.fox.ui.splash.SplashViewModel
import net.ihaha.sunny.fox.ui.welcome.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { BoardingViewModel(get()) }
    viewModel { SplashViewModel(get(), get()) }
    viewModel { WelcomeViewModel() }
}