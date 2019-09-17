package com.github.kacso.androidcommons.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.activities.BaseActivity
import com.github.kacso.androidcommons.core.fragments.BaseFragment
import com.github.kacso.androidcommons.extensions.attachFragment
import com.github.kacso.androidcommons.extensions.fragmenttransaction.decorators.FadeAnimation
import com.github.kacso.androidcommons.extensions.fragmenttransaction.decorators.SlideLeftToRightAnimation
import com.github.kacso.androidcommons.extensions.fragmenttransaction.decorators.SlideRightInPlaceAnimation
import com.github.kacso.androidcommons.extensions.fragmenttransaction.decorators.SlideUpToDownAnimation
import com.github.kacso.androidcommons.ui.fragments.EntryFilterableListFragment
import com.github.kacso.androidcommons.ui.fragments.LocationFragment
import com.github.kacso.androidcommons.ui.fragments.ProfileFragment
import com.github.kacso.androidcommons.ui.fragments.ViewPagerFragment
import com.github.kacso.androidcommons.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
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
    private var entryFilterableListFragment: EntryFilterableListFragment? = null
    private var profileFragment: BaseFragment? = null
    private var locationFragment: BaseFragment? = null

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
                R.id.navigationEntrySearchableList -> {
                    if (entryFilterableListFragment == null) {
                        entryFilterableListFragment = EntryFilterableListFragment.newInstance()
                    }
                    attachFragment(
                        R.id.fragmentHolder,
                        entryFilterableListFragment!!,
                        "EntryFilterableListFragment",
                        SlideUpToDownAnimation
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
                R.id.navigationLocation -> {
                    if (locationFragment == null) {
                        locationFragment = LocationFragment.newInstance()
                    }
                    attachFragment(
                        R.id.fragmentHolder,
                        locationFragment!!,
                        "LocationFragment",
                        SlideLeftToRightAnimation
                    )
                }
            }

            true
        }
}