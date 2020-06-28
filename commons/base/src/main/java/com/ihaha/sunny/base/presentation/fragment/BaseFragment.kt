package com.ihaha.sunny.base.presentation.fragment

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rasalexman.coroutinesmanager.ICoroutinesManager
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import com.ihaha.sunny.base.R
import com.ihaha.sunny.base.domain.DataState
import com.ihaha.sunny.base.domain.MessageType
import com.ihaha.sunny.base.domain.StateMessage
import com.ihaha.sunny.base.domain.UIComponentType
import com.ihaha.sunny.base.presentation.listeners.DataStateChangeListener
import com.ihaha.sunny.base.presentation.listeners.UICommunicationListener
import com.ihaha.sunny.base.utils.extentions.processViewEvent
import com.ihaha.sunny.ui.data.dto.SEvent
import com.ihaha.sunny.ui.data.dto.SResult
import com.ihaha.sunny.ui.extensions.*
import com.ihaha.sunny.base.utils.lifecycle.LifeCycleObserverUtils
import com.ihaha.sunny.ui.typealiases.UnitHandler
import com.ihaha.sunny.base.viewModels.IBaseViewModel

@FlowPreview
@ExperimentalCoroutinesApi
abstract class BaseFragment<out VM : IBaseViewModel> : Fragment(), ICoroutinesManager {

    //region variable
    @get:LayoutRes
    abstract val layoutId: Int

    protected open val contentViewLayout: View? = null
    protected open val loadingViewLayout: View? = null
    protected open val viewModel: VM? = null

    protected var dataStateChangeListener: DataStateChangeListener? = null
    protected var uiCommunicationListener: UICommunicationListener? = null


    private val autoLifeCycleObserver by lazy { LifeCycleObserverUtils(lifecycle) }
    //endregion

    //region override
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            dataStateChangeListener = context as DataStateChangeListener
            uiCommunicationListener = context as UICommunicationListener
        } catch (e: ClassCastException) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(layoutId, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        autoLifeCycleObserver.init(this)
    }

    override fun onDestroyView() {
        context?.closeAlert()
        super.onDestroyView()
    }

    //endregion

    //region method


    //endregion
}

