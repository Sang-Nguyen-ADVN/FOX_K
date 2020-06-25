package com.ihaha.sunny.fox.ui.main

import com.ihaha.sunny.base.viewModels.BaseViewModel

//
//val NAV_FRAGMENTS_ID = setOf(
//    R.id.navigation_home,
//    R.id.navigation_tags,
//    R.id.navigation_events,
//    R.id.navigation_more_horiz,
//    R.id.navigation_origanizations
//)
//
//class MainViewModel : BaseViewModel(){
//    private val _state = MutableLiveData<MainViewState>()
//    val state: LiveData<MainViewState>
//        get() = _state
//
//    /**
//     * Navigation controller add destination changed listener.
//     *
//     * @param navController Navigation manager.
//     */
//    fun navigationControllerChanged(navController: NavController) {
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            if (NAV_FRAGMENTS_ID.contains(destination.id)) {
//                _state.postValue(MainViewState.NavigationScreen)
//            } else {
//                _state.postValue(MainViewState.FullScreen)
//            }
//        }
//    }
//}

class MainViewModel : BaseViewModel(){}