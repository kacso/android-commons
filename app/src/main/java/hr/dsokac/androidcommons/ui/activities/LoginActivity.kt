package hr.dsokac.androidcommons.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import hr.dsokac.androidcommons.R
import hr.dsokac.androidcommons.core.activities.BaseActivity
import hr.dsokac.androidcommons.data.Resource
import hr.dsokac.androidcommons.viewmodel.LoginViewModel
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
        startActivity(NetworkActivity.getIntent(this))
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