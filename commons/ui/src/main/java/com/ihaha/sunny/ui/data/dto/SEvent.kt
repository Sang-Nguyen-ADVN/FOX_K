package com.ihaha.sunny.ui.data.dto

interface SEvent

object Fetch : SEvent
data class FetchWith<T : Any>(val data: T) : SEvent
object Refresh : SEvent
