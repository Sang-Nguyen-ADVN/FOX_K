//package net.ihaha.sunny.navigation
//
//import android.annotation.SuppressLint
//import android.app.Activity
//import android.content.Context
//import android.os.Parcelable
//import androidx.annotation.IdRes
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentActivity
//import androidx.fragment.app.FragmentManager
//import androidx.navigation.NavController
//import androidx.navigation.findNavController
//import androidx.navigation.fragment.NavHostFragment
//import androidx.navigation.fragment.findNavController
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import com.mi.mvi.R
//import kotlinx.android.parcel.Parcelize
//
///**
// * Class credit: Allan Veloso
// * I took the concept from Allan Veloso and made alterations to fit our needs.
// * https://stackoverflow.com/questions/50577356/android-jetpack-navigation-bottomnavigationview-with-youtube-or-instagram-like#_=_
// * @property navigationBackStack: Backstack for the bottom navigation
// */
//
//const val BOTTOM_NAV_BACKSTACK_KEY =
//    "com.mi.mvi.BottomNavController.bottom_nav_backstack"
//
//class BottomNavController(
//    val context: Context,
//    @IdRes val containerId: Int,
//    @IdRes val appStartDestinationId: Int,
//    val graphChangeListener: OnNavigationGraphChanged?
//) {
//    lateinit var navigationBackStack: BackStack
//    lateinit var activity: Activity
//    lateinit var fragmentManager: FragmentManager
//    lateinit var navItemChangeListener: OnNavigationItemChanged
//
//    init {
//        if (context is Activity) {
//            activity = context
//            fragmentManager = (activity as FragmentActivity).supportFragmentManager
//        }
//    }
//
//    fun setupBottomNavigationBackStack(previousBackStack: BackStack?) {
//        navigationBackStack = previousBackStack ?: BackStack.of(
//            appStartDestinationId
//        )
//    }
//
//    fun onNavigationItemSelected(menuItemId: Int = navigationBackStack.last()): Boolean {
//
//        // Replace fragment representing a navigation item
//        val fragment = fragmentManager.findFragmentByTag(menuItemId.toString())
//            ?: NavHostFragment.create(createNavHost(menuItemId))
//        fragmentManager.beginTransaction()
//            .setCustomAnimations(
//                R.anim.nav_default_enter_anim,
//                R.anim.nav_default_exit_anim,
//                R.anim.nav_default_pop_enter_anim,
//                R.anim.nav_default_pop_exit_anim
//            )
//            .replace(containerId, fragment, menuItemId.toString())
//            .addToBackStack(null)
//            .commit()
//
//        // Add to back stack
//        navigationBackStack.moveLast(menuItemId)
//
//        // Update checked icon
//        navItemChangeListener.onItemChanged(menuItemId)
//
//        // communicate with Activity
//        graphChangeListener?.onGraphChange()
//
//        return true
//    }
//
//    private fun createNavHost(menuItemId: Int) = when (menuItemId) {
//        R.id.navigation_home -> {
//            R.navigation.navigation_home
//        }
//        R.id.navigation_events -> {
//            R.navigation.navigation_event
//        }
//        R.id.navigation_more -> {
//            R.navigation.navigation_more
//        }
//        R.id.navigation_organizations -> {
//            R.navigation.navigation_more
//        }
//        else{
//            R.navigation.navigation_more
//        }
//    }
//
//    @SuppressLint("RestrictedApi")
//    fun onBackPressed() {
//        val navController = fragmentManager.findFragmentById(containerId)!!
//            .findNavController()
//        when {
//            // We should always try to go back on the child fragment manager stack before going to
//            // the navigation stack. It's important to use the child fragment manager instead of the
//            // NavController because if the user change tabs super fast commit of the
//            // supportFragmentManager may mess up with the NavController child fragment manager back
//            // stack
//
//            navController.backStack.size > 2 -> {
//                navController.popBackStack()
//            }
//
//            // Fragment back stack is empty so try to go back on the navigation stack
//            navigationBackStack.size > 1 -> {
//                // Remove last item from back stack
//                navigationBackStack.removeLast()
//
//                // Update the container with new fragment
//                onNavigationItemSelected()
//            }
//            // If the stack has only one and it's not the navigation home we should
//            // ensure that the application always leave from startDestination
//            navigationBackStack.last() != appStartDestinationId -> {
//                navigationBackStack.removeLast()
//                navigationBackStack.add(0, appStartDestinationId)
//                onNavigationItemSelected()
//            }
//            // Navigation stack is empty, so finish the activity
//            else -> {
//                activity.finish()
//            }
//        }
//    }
//
//    @Parcelize
//    class BackStack : ArrayList<Int>(), Parcelable {
//        companion object {
//            fun of(vararg elements: Int): BackStack {
//                val b =
//                    BackStack()
//                b.addAll(elements.toTypedArray())
//                return b
//            }
//        }
//
//        fun removeLast() = removeAt(size - 1)
//
//        fun moveLast(item: Int) {
//            remove(item) // if present, remove
//            add(item) // add to end of list
//        }
//    }
//
//    // For setting the checked icon in the bottom nav
//    interface OnNavigationItemChanged {
//        fun onItemChanged(itemId: Int)
//    }
//
//    // Execute when Navigation Graph changes.
//    // ex: Select a new item on the bottom navigation
//    // ex: Home -> Account
//    interface OnNavigationGraphChanged {
//        fun onGraphChange()
//    }
//
//    interface OnNavigationReselectedListener {
//        fun onReselectNavItem(navController: NavController, fragment: Fragment)
//    }
//
//    fun setOnItemNavigationChanged(listener: (itemId: Int) -> Unit) {
//        this.navItemChangeListener = object :
//            OnNavigationItemChanged {
//            override fun onItemChanged(itemId: Int) {
//                listener.invoke(itemId)
//            }
//        }
//    }
//}
//
//// Convenience extension to set up the navigation
//fun BottomNavigationView.setUpNavigation(
//    bottomNavController: BottomNavController,
//    onReselectListener: BottomNavController.OnNavigationReselectedListener
//) {
//    setOnNavigationItemSelectedListener {
//        bottomNavController.onNavigationItemSelected(it.itemId)
//    }
//    setOnNavigationItemReselectedListener {
//        bottomNavController
//            .fragmentManager
//            .findFragmentById(bottomNavController.containerId)!!
//            .childFragmentManager
//            .fragments[0]?.let { fragment ->
//            onReselectListener.onReselectNavItem(
//                bottomNavController.activity.findNavController(bottomNavController.containerId),
//                fragment
//            )
//        }
//        bottomNavController.onNavigationItemSelected()
//    }
//
//    bottomNavController.setOnItemNavigationChanged { itemId ->
//        menu.findItem(itemId).isChecked = true
//    }
//}
