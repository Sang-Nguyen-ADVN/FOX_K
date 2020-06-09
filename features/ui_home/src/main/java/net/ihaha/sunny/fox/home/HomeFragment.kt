package net.ihaha.sunny.fox.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.layout_item_tab.view.*
import net.ihaha.sunny.base.presentation.fragment.BaseFragment
import net.ihaha.sunny.base.presentation.viewpager.BaseTabViewPagerFragment
import net.ihaha.sunny.fox.home.databinding.FragmentHomeBinding
import net.ihaha.sunny.fox.home.di.injectFeature
import net.ihaha.sunny.fox.home.di.removeFeature
import net.ihaha.sunny.fox.home.editors_choice.EditorsChoiceFragment
import net.ihaha.sunny.fox.home.newest.NewestFragment
import net.ihaha.sunny.fox.home.series.SeriesFragment
import net.ihaha.sunny.fox.home.trending.TrendingFragment
import net.ihaha.sunny.fox.home.video.VideoFragment
import net.ihaha.sunny.ui.extensions.color
import net.ihaha.sunny.ui.extensions.drawable
import net.ihaha.sunny.ui.extensions.unsafeLazy


/**
 * Author : Sunny
 * Date   : 25-04-2020
 * Version: 1.0.0
 */

class HomeFragment : BaseTabViewPagerFragment<FragmentHomeBinding, HomeViewModel>() {


    //region override

    override val pageTitles: Array<String> by unsafeLazy {
        resources.getStringArray(R.array.title_array_home)
    }

    override val pages: List<BaseFragment<*>> by unsafeLazy {
        listOf(
            NewestFragment.newInstances(),
            TrendingFragment.newInstances(),
            SeriesFragment.newInstances(),
            EditorsChoiceFragment.newInstances(),
            VideoFragment.newInstances()
        )
    }

    private val tabBackground by unsafeLazy { drawable(R.drawable.bg_tab_selected) }
    private val selectedTabColor by unsafeLazy { color(R.color.black) }
    private val unselectedTabColor by unsafeLazy { color(R.color.white) }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_account -> return true
            R.id.menu_search -> return true
        }
        return false
    }

    override fun setCustomTabView(tab: TabLayout.Tab, position: Int) {
        val tabView = LayoutInflater.from(context).inflate(R.layout.layout_item_tab, null)
        val tabTextView = tabView.findViewById<AppCompatTextView>(R.id.tabTextView)
        tabTextView.text = pageTitles[position]
        tab.customView = tabView
        if (selectedPosition == position) selectTab(tab)
    }

    override fun selectTab(tab: TabLayout.Tab) {
        super.selectTab(tab)
        tab.customView?.tabTextView?.apply {
            setTextColor(selectedTabColor)
            background = tabBackground
        }
    }

    override fun unSelectTab(tab: TabLayout.Tab?) {
        tab?.customView?.tabTextView?.apply {
            setTextColor(unselectedTabColor)
            background = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        removeFeature()
    }

    //endregion


}