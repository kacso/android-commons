package com.github.kacso.androidcommons.ui.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.activities.BaseActivity
import com.github.kacso.androidcommons.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : BaseActivity() {
    override val layoutRes: Int = R.layout.activity_splash

    override val viewModel: SplashViewModel by viewModels()


    override fun getContentHolder(): View = contentHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        viewModel.persistLogin().observe(this, Observer {
            startActivity(MainActivity.getIntent(this))
            finish()
        })
    }

    override fun redirectToLogin(forceRedirect: Boolean) {
        super.redirectToLogin(true)
    }
}