package com.ihaha.sunny.base.presentation.listeners

import com.ihaha.sunny.base.domain.DataState


interface DataStateChangeListener {
    fun onDataStateChangeListener(dataState: DataState<*>?)
}
