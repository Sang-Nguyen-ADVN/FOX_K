package net.ihaha.sunny.fox.ui.welcome

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rasalexman.coroutinesmanager.ICoroutinesManager
import net.ihaha.sunny.fox.R
import net.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import net.ihaha.sunny.fox.ui.main.MainActivity

class WelcomeActivity : AppCompatActivity(), OnListenerNavigationToMainActivity, ICoroutinesManager {

    //region variable

    //endregion

    //region override

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initComponents()
        initEventListeners()
    }

    override fun onNavigation() {
        Thread.sleep(4000)
        val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    //endregion

    //region method

    private fun initComponents() {

    }

    private fun initEventListeners() {

    }

    //endregion
}