package net.ihaha.sunny.fox.ui.welcome

import android.content.Intent
import android.os.Bundle
import com.rasalexman.coroutinesmanager.ICoroutinesManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.ihaha.sunny.base.presentation.activity.BaseActivity
import net.ihaha.sunny.fox.R
import net.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import net.ihaha.sunny.fox.ui.splash.SplashFragment

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

    override fun onNavigation() {
        launch {
            delay(2000)
            val intent = Intent(this@WelcomeActivity, SplashFragment::class.java)
            startActivity(intent)
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