package com.ihaha.sunny.base.presentation.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.layout_tab_fixed.*
import com.ihaha.sunny.base.R
import com.ihaha.sunny.base.viewModels.IBaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
abstract class BaseTabViewPagerFragment<VB : ViewDataBinding, out VM : IBaseViewModel> : BaseViewPagerFragment<VB,VM>(), TabSelectListener {

    //region variable
    abstract val pageTitles: Array<String>

    protected open val tabViewLayout: TabLayout? get() = tabLayout as TabLayout
    protected open val selectedPosition: Int get() = viewModel?.getFromSaveState(KEY_POSITION) ?: DEFAULT_POSITION
    protected open fun selectTab(tab: TabLayout.Tab) { selectedTab = tab }
    protected open fun unSelectTab(tab: TabLayout.Tab?) = Unit
    protected open fun setCustomTabView(tab: TabLayout.Tab, position: Int) = Unit

    private var selectedTab: TabLayout.Tab? = null
    private var tabLayoutMediator: TabLayoutMediator? = null
    //endregion
    override val layoutId: Int get() = R.layout.layout_tab_viewpager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(viewPagerLayout != null && tabViewLayout != null) {
            tabLayoutMediator = TabLayoutMediator(tabViewLayout!!, viewPagerLayout!!) { tab, position ->
                setCustomTabView(tab, position)
            }.apply { attach() }

            viewPagerLayout?.setCurrentItem(selectedPosition, false)
            tabViewLayout?.addOnTabSelectedListener(this)
        }
    }

    @ExperimentalCoroutinesApi @FlowPreview
    override fun onTabSelected(tab: TabLayout.Tab) {
        viewModel?.addToSaveState(KEY_POSITION, tab.position)
        unSelectTab(selectedTab)
        selectTab(tab)
        selectedTab = tab
    }

    @ExperimentalCoroutinesApi @FlowPreview
    override fun onDestroyView() {
        selectedTab = null
        tabLayoutMediator?.detach()
        tabLayoutMediator = null
        super.onDestroyView()
    }

    //region method

    //endregion

    companion object {
        private const val KEY_POSITION = "SELECTED_POSITION"
        private const val DEFAULT_POSITION = 0
    }
}
