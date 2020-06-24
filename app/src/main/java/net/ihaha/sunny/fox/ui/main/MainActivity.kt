package net.ihaha.sunny.fox.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import net.ihaha.sunny.base.presentation.activity.BaseActivity
import net.ihaha.sunny.fox.R
import net.ihaha.sunny.fox.ui.callback.OnListenerChangeLanguage
import net.ihaha.sunny.fox.ui.callback.OnListenerChangeTheme
import net.ihaha.sunny.navigation.setupWithNavController
import net.ihaha.sunny.ui.extensions.slideDown
import net.ihaha.sunny.ui.extensions.slideUp
import net.ihaha.sunny.utils.prefs.SharePrefsManager
import net.ihaha.sunny.utils.prefs.SharedPrefKeys
import net.ihaha.sunny.utils.settings.language.LanguageUtilsImpl
import net.ihaha.sunny.utils.settings.theme.ThemeUtilsImpl
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity(R.layout.activity_main), OnListenerChangeTheme, OnListenerChangeLanguage {

    //region variable
    private var currentNavController: LiveData<NavController>? = null

    private val themeUtilsImpl : ThemeUtilsImpl by inject()
    private val languageUtilsImpl : LanguageUtilsImpl by inject()
    private val sharePrefsManager : SharePrefsManager by inject()

    //endregion

    //region set and get

    //endregion

    //region override

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        } // Else, need to wait for onRestoreInstanceState

        setUpNavDestinationChangeListener()
    }

    companion object {
        private const val DELAY_TO_APPLY_THEME = 1000L
    }

    override fun changeTheme(isChange: Boolean) {
        if(isChange) {
            sharePrefsManager.setTheme(SharedPrefKeys.Theme.DARK_MODE)
            themeUtilsImpl.setNightMode(true)
        }
        else {
            sharePrefsManager.setTheme(SharedPrefKeys.Theme.LIGHT_MODE)
            themeUtilsImpl.setNightMode(false)
        }
    }

    override fun changeLanguage(isChange: Boolean) {

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    override fun displayLoading(isLoading: Boolean) {

    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    //endregion

    //region method

    private fun setUpNavDestinationChangeListener() {
        val destinationChangeListener = DestinationChangeListener()
        currentNavController?.observe(this) {
            it.addOnDestinationChangedListener(destinationChangeListener)
        }
    }

    private fun setupBottomNavigationBar() {
        val bottomNavigationView = bottom_navigation

        val navGraphIds = listOf(
            R.navigation.navigation_login,
            R.navigation.navigation_home,
            R.navigation.navigation_tags,
            R.navigation.navigation_event,
            R.navigation.navigation_origanizations,
            R.navigation.navigation_more
        )

        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        currentNavController?.observe(this, Observer { navController ->
            setupActionBarWithNavController(navController)
        })

        currentNavController = controller
    }

    inner class DestinationChangeListener() : NavController.OnDestinationChangedListener {
        override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
            toolbar.title = destination.label
            collasping_toolbar.isTitleEnabled = false;
            collasping_toolbar.title = destination.label
//            if (destination.id == R.id.detailsFragment) {
//                findViewById<AppBarLayout>(R.id.app_bar).setExpanded(false)
//                hideBottomTabs()
//            } else {
//                showBottomTabs()
//            }
        }
    }

    private fun hideBottomTabs() {
        if (bottom_navigation.visibility == View.VISIBLE) {
            bottom_navigation.slideDown()
        }
    }

    private fun showBottomTabs() {
        if (bottom_navigation.visibility != View.VISIBLE) {
            bottom_navigation.slideUp()
        }
    }

    //endregion


}