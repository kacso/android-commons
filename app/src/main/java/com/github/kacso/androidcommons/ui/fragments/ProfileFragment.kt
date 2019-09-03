package com.github.kacso.androidcommons.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.fragments.BaseFragment
import com.github.kacso.androidcommons.data.Resource
import com.github.kacso.androidcommons.extensions.show
import com.github.kacso.androidcommons.models.ui.User
import com.github.kacso.androidcommons.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : BaseFragment() {
    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override val viewModel: ProfileViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initListeners()
    }

    private fun initUI() {
        viewModel.getUser().observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    hideProgress()
                    displayGreeting(it.data!!)
                }
                is Resource.Error -> {
                    hideProgress()
                    onError(it.error!!)
                }
                is Resource.Loading -> {
                    showProgress()
                    it.data?.let { user -> displayGreeting(user) }
                }
            }
        })
    }

    private fun displayGreeting(user: User) {
        rootView.userGreeting.text =
            getString(R.string.user_greeting, user.toString())
        rootView.userGreeting.show(true)
    }

    private fun initListeners() {
        rootView.logoutBtn.setOnClickListener {
            viewModel.logout().observe(viewLifecycleOwner, Observer {
                when (it) {
                    is Resource.Success -> {
                        hideProgress()
                        redirectToLogin(true)
                    }
                    is Resource.Loading -> showProgress()
                    is Resource.Error -> {
                        hideProgress()
                        onError(it.error!!)
                    }
                }
            })
        }
    }
}