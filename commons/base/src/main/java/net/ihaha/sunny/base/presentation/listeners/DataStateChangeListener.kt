package net.ihaha.sunny.base.presentation.listeners

import net.ihaha.sunny.base.domain.DataState


interface DataStateChangeListener {
    fun onDataStateChangeListener(dataState: DataState<*>?)
}
