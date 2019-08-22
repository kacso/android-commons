package hr.dsokac.androidcommons.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import hr.dsokac.androidcommons.R
import hr.dsokac.androidcommons.core.activities.BaseActivity
import hr.dsokac.androidcommons.core.fragments.BaseFragment
import hr.dsokac.androidcommons.extensions.attachFragment
import hr.dsokac.androidcommons.extensions.fragmenttransaction.decorators.FadeAnimation
import hr.dsokac.androidcommons.extensions.fragmenttransaction.decorators.SlideRightInPlaceAnimation
import hr.dsokac.androidcommons.ui.fragments.ProfileFragment
import hr.dsokac.androidcommons.ui.fragments.ViewPagerFragment
import hr.dsokac.androidcommons.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    companion object {
        fun getIntent(context: Context?): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override val viewModel: MainViewModel by viewModels()

    override val layoutRes: Int = R.layout.activity_main

    override fun getContentHolder(): View = contentHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBottomNavigation()
    }

    override fun onBackPressed() {
        if (bottomNavigation.selectedItemId == R.id.navigationViewPager) {
            super.onBackPressed()
        } else {
            bottomNavigation.selectedItemId = R.id.navigationViewPager
        }
    }

    private fun initBottomNavigation() {
        bottomNavigation.inflateMenu(R.menu.menu_bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        bottomNavigation.selectedItemId = R.id.navigationViewPager
    }

    private var viewPagerFragment: BaseFragment? = null
    private var profileFragment: BaseFragment? = null

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigationViewPager -> {
                    if (viewPagerFragment == null) {
                        viewPagerFragment = ViewPagerFragment.newInstance()
                    }
                    attachFragment(
                        R.id.fragmentHolder,
                        viewPagerFragment!!,
                        "ViewPagerFragment",
                        FadeAnimation
                    )
                }
                R.id.navigationUserProfile -> {
                    if (profileFragment == null) {
                        profileFragment = ProfileFragment.newInstance()
                    }
                    attachFragment(
                        R.id.fragmentHolder,
                        profileFragment!!,
                        "ProfileFragment",
                        SlideRightInPlaceAnimation
                    )
                }
            }

            true
        }
}