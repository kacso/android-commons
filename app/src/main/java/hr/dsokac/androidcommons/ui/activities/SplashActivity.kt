package hr.dsokac.androidcommons.ui.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import hr.dsokac.androidcommons.R
import hr.dsokac.androidcommons.core.activities.BaseActivity
import hr.dsokac.androidcommons.viewmodel.SplashViewModel
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