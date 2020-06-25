package com.ihaha.sunny.base.utils.extentions

import android.app.Activity
import androidx.lifecycle.*
import com.afollestad.materialdialogs.MaterialDialog
import com.rasalexman.coroutinesmanager.CoroutinesProvider
import com.ihaha.sunny.base.domain.AreYouSureCallBack
import com.ihaha.sunny.base.viewModels.BaseViewModel
import com.ihaha.sunny.base.viewModels.IBaseViewModel
import com.ihaha.sunny.ui.R
import com.ihaha.sunny.ui.data.dto.SEvent
import com.ihaha.sunny.ui.data.dto.SResult
import com.ihaha.sunny.ui.extensions.applyForType

/**
 *
 */
inline fun<reified T> BaseViewModel.asyncLiveData(noinline block: suspend LiveDataScope<T>.() -> Unit) =
    liveData(context = viewModelScope.coroutineContext + CoroutinesProvider.IO, block = block)


inline fun<reified E : SEvent> BaseViewModel.onEventResult(crossinline block: suspend LiveDataScope<SResult<*>>.(E) -> Unit): LiveData<SResult<*>> {
    return eventLiveData.switchMap {
        asyncLiveData<SResult<*>> {
            it.applyForType<E> { this.block(it) }
        }
    }
}

/**
 *
 */
inline fun<reified E : SEvent, reified T : Any> BaseViewModel.onEvent(crossinline block: suspend LiveDataScope<T>.(E) -> Unit): LiveData<T> {
    return eventLiveData.switchMap {
        asyncLiveData<T> {
            it.applyForType<E> { this.block(it) }
        }
    }
}

fun SavedStateHandle.getCurrentPage(key: String, latPage: Int): Int {
    val savedPage = this.get<Int>(key)?.plus(1)
    val currentPage = savedPage?.takeIf { it > latPage } ?: latPage
    this.set(key, currentPage)
    return currentPage
}


/**
 * Process [SEvent] from Presentation View Controller (such as Activity or Fragment) to ViewModel
 *
 * @param viewEvent [SEvent] - any implementation to handler with this fragment
 */
fun IBaseViewModel.processViewEvent(viewEvent: SEvent) {
    eventLiveData.value = viewEvent
}

var materialDialog: MaterialDialog? = null

fun Activity.displaySuccessDialog(message: String) {
    materialDialog = MaterialDialog(this)
        .show {
            title(R.string.text_success)
            message(text = message)
            positiveButton(R.string.text_ok)
        }
}

fun Activity.displayErrorDialog(message: String) {
    materialDialog = MaterialDialog(this)
        .show {
            title(R.string.text_error)
            message(text = message)
            positiveButton(R.string.text_ok)
        }
}

fun Activity.displayInfoDialog(message: String?) {
    materialDialog = MaterialDialog(this)
        .show {
            title(R.string.are_you_sure)
            message(text = message)
            positiveButton(R.string.text_ok)
        }
}

fun Activity.areYouSureDialog(message: String?, callback: AreYouSureCallBack) {
    materialDialog = MaterialDialog(this)
        .show {
            title(R.string.text_info)
            message(text = message)
            positiveButton(R.string.text_ok) {
                callback.proceed()
            }
            negativeButton(R.string.text_cancel) {
                callback.cancel()
                materialDialog = null
            }
        }
}