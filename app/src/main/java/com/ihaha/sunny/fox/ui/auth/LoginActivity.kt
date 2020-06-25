package com.ihaha.sunny.fox.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rasalexman.coroutinesmanager.ICoroutinesManager
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import com.ihaha.sunny.fox.ui.main.MainActivity

class LoginActivity : AppCompatActivity(), OnListenerNavigationToMainActivity, ICoroutinesManager {

    //region variable

    //endregion

    //region override

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initComponents()
        initEventListeners()
    }

    override fun onNavigation() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
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