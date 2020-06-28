package com.ihaha.sunny.base.presentation.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.layout_viewpager.*
import com.ihaha.sunny.base.R
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.base.presentation.fragment.BaseFragment
import com.ihaha.sunny.base.viewModels.IBaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
abstract class BaseViewPagerFragment< VB : ViewDataBinding,out VM : IBaseViewModel> : BaseBindingFragment<VB,VM>() {

    //region variable
    abstract val pages: List<BaseFragment<*>>
    protected open val viewPagerLayout: ViewPager2? get() = viewPager as ViewPager2
    protected open val viewPagerOrientation: Int get() = ViewPager2.ORIENTATION_HORIZONTAL
    //endregion

    //region override

    override val layoutId: Int get() = R.layout.layout_viewpager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPagerLayout?.orientation = viewPagerOrientation
        initViewPagerAdapter()
    }

    protected open fun initViewPagerAdapter() {
        viewPagerLayout?.adapter = createViewPagerAdapter()
        viewPagerLayout?.isSaveEnabled = false
    }

    protected open fun createViewPagerAdapter(): RecyclerView.Adapter<*> {
        return BaseViewPagerFragmentAdapter(pages, this)
    }

    //endregion

    //region method
    open class BaseViewPagerFragmentAdapter(private val adapterPages: List<BaseFragment<*>>, fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = adapterPages.size
        override fun createFragment(position: Int): Fragment = adapterPages[position]
    }
    //endregion
}