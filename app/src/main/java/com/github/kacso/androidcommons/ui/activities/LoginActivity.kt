package com.github.kacso.androidcommons.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.activities.BaseActivity
import com.github.kacso.androidcommons.data.Resource
import com.github.kacso.androidcommons.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity() {
    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            return intent
        }
    }

    override val viewModel: LoginViewModel by viewModels()

    override fun getContentHolder(): View = contentHolder

    override val layoutRes: Int = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initListeners()
    }

    private fun onLoginSuccess() {
        startActivity(MainActivity.getIntent(this))
        finish()
    }

    override fun redirectToLogin(forceRedirect: Boolean) {
        //Do nothing, we are already on login
    }

    private fun initListeners() {
        loginBtn.setOnClickListener {
            viewModel.login(
                username = usernameInput.text?.toString() ?: "",
                password = passwordInput.text?.toString() ?: ""
            ).observe(this, Observer {
                when (it) {
                    is Resource.Loading -> showProgress()
                    is Resource.Error -> {
                        onError(it.error!!)
                        hideProgress()
                    }
                    is Resource.Success -> {
                        onLoginSuccess()
                        hideProgress()
                    }
                }
            })
        }
    }
}