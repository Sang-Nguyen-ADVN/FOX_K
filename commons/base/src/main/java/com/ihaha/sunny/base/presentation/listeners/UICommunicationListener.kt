package com.ihaha.sunny.base.presentation.listeners

import com.ihaha.sunny.base.domain.StateMessage


interface UICommunicationListener {
    fun onUIMessageReceived(stateMessage: StateMessage)
    fun displayLoading(isLoading: Boolean)
}
