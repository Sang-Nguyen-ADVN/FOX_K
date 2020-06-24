package net.ihaha.sunny.base.presentation.listeners

import net.ihaha.sunny.base.domain.StateMessage


interface UICommunicationListener {
    fun onUIMessageReceived(stateMessage: StateMessage)
    fun displayLoading(isLoading: Boolean)
}
