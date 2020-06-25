package com.ihaha.sunny.fox.ui.main

import com.ihaha.sunny.base.viewModels.BaseViewState

sealed class MainViewState : BaseViewState {

    /**
     * Full screen mode.
     */
    object FullScreen : MainViewState()

    /**
     * Navigation screen mode with bottom bar.
     */
    object NavigationScreen : MainViewState()

    // ============================================================================================
    //  Public helpers methods
    // ============================================================================================

    /**
     * Check if current view state is [FullScreen].
     *
     * @return True if is full screen state, otherwise false.
     */
    fun isFullScreen() = this is FullScreen

    /**
     * Check if current view state is [NavigationScreen].
     *
     * @return True if is navigation screen state, otherwise false.
     */
    fun isNavigationScreen() = this is NavigationScreen
}