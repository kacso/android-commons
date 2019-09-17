package com.github.kacso.androidcommons.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.fragments.BaseFragment
import com.github.kacso.androidcommons.core.mvvm.viewmodels.IBaseViewModel
import com.github.kacso.androidcommons.data.Resource
import com.github.kacso.androidcommons.location.LocationProvider
import com.github.kacso.androidcommons.location.RXLocationProvider
import com.github.kacso.androidcommons.location.SingleShotLocationProvider
import com.github.kacso.androidcommons.location.exceptions.LocationDisabledException
import com.github.kacso.androidcommons.logger.log
import com.github.kacso.androidcommons.permissions.LOCATION_PERMISSIONS
import com.github.kacso.androidcommons.permissions.callbacks.PermissionCallback
import com.google.android.gms.location.LocationRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_location.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocationFragment : BaseFragment() {
    companion object {
        fun newInstance(): LocationFragment {
            return LocationFragment()
        }
    }

    override val viewModel: IBaseViewModel? = null

    override val layoutRes: Int = R.layout.fragment_location

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        permissionManager.requirePermissions(LOCATION_PERMISSIONS, object : PermissionCallback {
            override fun onAllowed() {
                initSingleShotLocation()
                initLiveDataLocation()
                initRxJavaLocation()
            }

            override fun onDisallowed() {
                rootView.singleShotLocation.text =
                    getString(R.string.error_location_permissions_missing)
                rootView.liveDataLocation.text =
                    getString(R.string.error_location_permissions_missing)
                rootView.rxJavaLocation.text =
                    getString(R.string.error_location_permissions_missing)
            }
        })
    }

    @SuppressLint("MissingPermission")
    private fun initSingleShotLocation() {
        GlobalScope.launch {
            context?.apply {
                val location = SingleShotLocationProvider.requestSingleUpdate(this)

                rootView.singleShotLocation.text = getString(
                    R.string.single_shot_location,
                    location.latitude,
                    location.longitude
                )
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun initLiveDataLocation() {
        LocationProvider(
            context!!,
            LocationRequest.create().setFastestInterval(1000).setInterval(5000)
        ).getLocation().observe(viewLifecycleOwner, Observer {
            if (it is Resource.Success) {
                rootView.liveDataLocation.text = getString(
                    R.string.live_data_location,
                    it.data?.latitude,
                    it.data?.longitude
                )
            } else if (it is Resource.Error) {
                if (it.error?.cause is LocationDisabledException) {
                    rootView.liveDataLocation.text =
                        getString(R.string.error_location_permissions_missing)
                } else {
                    rootView.liveDataLocation.text =
                        getString(it.error?.errorRes ?: R.string.error_unexpected)
                }
            }
        })
    }

    @SuppressLint("MissingPermission")
    private fun initRxJavaLocation() {
        RXLocationProvider(
            context!!,
            LocationRequest.create().setFastestInterval(1000).setInterval(5000)
        ).getLocationObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                rootView.rxJavaLocation.text = getString(
                    R.string.rxjava_location,
                    it.latitude,
                    it.longitude
                )
            }, {
                it.log()
                if (it is LocationDisabledException) {
                    rootView.rxJavaLocation.text =
                        getString(R.string.error_location_permissions_missing)
                } else {
                    rootView.rxJavaLocation.text = getString(R.string.error_unexpected)
                }
            })
    }

}