package net.ihaha.sunny.base.presentation.activity

import android.content.SharedPreferences
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import net.ihaha.sunny.base.BR
import net.ihaha.sunny.ui.extensions.hideKeyboard
import net.ihaha.sunny.base.utils.lifecycle.LifeCycleObserverUtils
import net.ihaha.sunny.base.viewModels.BaseViewModel
import net.ihaha.sunny.base.viewModels.IBaseViewModel
import org.koin.android.ext.android.inject


abstract class BaseActivity<T: ViewDataBinding>() : AppCompatActivity() {

    @get:LayoutRes
    abstract val layoutId: Int

    protected lateinit var viewBinding: T

    private val sharedPreferences: SharedPreferences by inject()

    protected val autoLifeCycleObserver by lazy { LifeCycleObserverUtils(lifecycle) }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoLifeCycleObserver.init(this)
        if (::viewBinding.isInitialized.not()) {
            viewBinding = DataBindingUtil.setContentView(this, layoutId)
            viewBinding.apply {
                executePendingBindings()
            }
            viewBinding.lifecycleOwner = this
        }
    }

    override fun finish() {
        hideKeyboard()
        super.finish()
    }
}