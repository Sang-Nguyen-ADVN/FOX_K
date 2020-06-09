package net.ihaha.sunny.base.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.ihaha.sunny.ui.data.dto.SEvent
import net.ihaha.sunny.ui.data.dto.SResult

interface IBaseViewModel {

    val eventLiveData: MutableLiveData<SEvent>
    val anyLiveData: LiveData<*>?
    val resultLiveData: LiveData<*>?
    val errorLiveData: MutableLiveData<SResult<*>>

    fun <T : Any> addToSaveState(key: String, value: T)
    fun <T : Any> getFromSaveState(key: String): T?
}