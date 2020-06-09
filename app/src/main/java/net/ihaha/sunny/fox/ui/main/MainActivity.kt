package net.ihaha.sunny.fox.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.ui.setupActionBarWithNavController
import net.ihaha.sunny.base.presentation.activity.BaseActivity
import net.ihaha.sunny.fox.R
import net.ihaha.sunny.fox.databinding.ActivityMainBinding
import net.ihaha.sunny.fox.ui.callback.OnListenerChangeLanguage
import net.ihaha.sunny.fox.ui.callback.OnListenerChangeTheme
import net.ihaha.sunny.navigation.setupWithNavController
import net.ihaha.sunny.ui.extensions.slideDown
import net.ihaha.sunny.ui.extensions.slideUp
import net.ihaha.sunny.ui.view.ui.ToggleThemeCheckBoxView
import net.ihaha.sunny.utils.prefs.SharePrefsManager
import net.ihaha.sunny.utils.prefs.SharedPrefKeys
import net.ihaha.sunny.utils.settings.language.LanguageUtilsImpl
import net.ihaha.sunny.utils.settings.theme.ThemeUtilsImpl
import org.koin.android.ext.android.inject


@Suppress("UNREACHABLE_CODE")
class MainActivity : BaseActivity<ActivityMainBinding>(), OnListenerChangeTheme, OnListenerChangeLanguage {

    //region variable
    private var currentNavController: LiveData<NavController>? = null

    private val themeUtilsImpl : ThemeUtilsImpl by inject()
    private val languageUtilsImpl : LanguageUtilsImpl by inject()
    private val sharePrefsManager : SharePrefsManager by inject()

    //endregion

    //region set and get

    //endregion

    //region override

    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(viewBinding.toolbar)

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
        val bottomNavigationView = viewBinding.bottomNavigation

        val navGraphIds = listOf(
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
            viewBinding.toolbar.title = destination.label
            viewBinding.collaspingToolbar.isTitleEnabled = false;
            viewBinding.collaspingToolbar.title = destination.label
//            if (destination.id == R.id.detailsFragment) {
//                findViewById<AppBarLayout>(R.id.app_bar).setExpanded(false)
//                hideBottomTabs()
//            } else {
//                showBottomTabs()
//            }
        }
    }

    private fun hideBottomTabs() {
        if (viewBinding.bottomNavigation.visibility == View.VISIBLE) {
            viewBinding.bottomNavigation.slideDown()
        }
    }

    private fun showBottomTabs() {
        if (viewBinding.bottomNavigation.visibility != View.VISIBLE) {
            viewBinding.bottomNavigation.slideUp()
        }
    }

    //endregion


}