package com.ihaha.sunny.fox.ui.welcome

import android.content.Intent
import android.os.Bundle
import com.rasalexman.coroutinesmanager.ICoroutinesManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.ihaha.sunny.base.presentation.activity.BaseActivity
import com.ihaha.sunny.fox.Constants
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.ui.auth.LoginActivity
import com.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import com.ihaha.sunny.fox.ui.main.MainActivity
import com.ihaha.sunny.fox.ui.splash.SplashFragment

class WelcomeActivity : BaseActivity(R.layout.activity_welcome), ICoroutinesManager, OnListenerNavigationToMainActivity {

    //region variable

    //endregion

    //region override

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponents()
        initEventListeners()
    }

    override fun displayLoading(isLoading: Boolean) {

    }

    override fun onNavigation(page : String) {
        launch {
            delay(2000)
            if(page == Constants.ACTIVITY_MAIN) {
                val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
                startActivity(intent)
            }else if(page == Constants.ACTIVITY_LOGIN){
                val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
                startActivity(intent)
            }
            finish()
        }
    }

    //endregion

    //region method

    private fun initComponents() {

    }

    private fun initEventListeners() {

    }

    //endregion
}