package com.ihaha.sunny.fox.di

import com.ihaha.sunny.fox.ui.boarding.BoardingViewModel
import com.ihaha.sunny.fox.ui.auth.ResetPasswordViewModel
import com.ihaha.sunny.fox.ui.auth.SignInViewModel
import com.ihaha.sunny.fox.ui.auth.SignUpViewModel
import com.ihaha.sunny.fox.ui.main.MainViewModel
import com.ihaha.sunny.fox.ui.splash.SplashViewModel
import com.ihaha.sunny.fox.ui.welcome.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { BoardingViewModel(get()) }
    viewModel { SplashViewModel(get(), get()) }
    viewModel { WelcomeViewModel(get()) }
    viewModel { SignInViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { ResetPasswordViewModel(get()) }
}