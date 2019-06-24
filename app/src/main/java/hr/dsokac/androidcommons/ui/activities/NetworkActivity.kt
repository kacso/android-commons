package hr.dsokac.androidcommons.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hr.dsokac.androidcommons.R
import hr.dsokac.androidcommons.network.managers.AppNetworkManager
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_network.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NetworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_network)

        networkReqSingleBtn.setOnClickListener {
            AppNetworkManager.getService().getSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Toast.makeText(this, "Request successful", Toast.LENGTH_LONG).show()
                    Log.d("Network", it.string())
                }, {
                    Toast.makeText(this, "Request failed", Toast.LENGTH_LONG).show()
                    Log.d("Network", "" + it.message)
                })
        }

        networkReqSuspendBtn.setOnClickListener {
            GlobalScope.launch {
                runCatching {
                    AppNetworkManager.getService().getSuspend()
                }.onSuccess {
                    runOnUiThread {
                        Toast.makeText(this@NetworkActivity, "Request successful", Toast.LENGTH_LONG).show()
                    }
                    Log.d("Network", it.string())
                }.onFailure {
                    runOnUiThread {
                        Toast.makeText(this@NetworkActivity, "Request failed", Toast.LENGTH_LONG).show()
                    }
                    Log.d("Network", "" + it.message)
                }
            }
        }

        networkBadReqSingleBtn.setOnClickListener {
            AppNetworkManager.getService().getBadSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Toast.makeText(this, "Request successful", Toast.LENGTH_LONG).show()
                    Log.d("Network", it.string())
                }, {
                    Toast.makeText(this, "Request failed", Toast.LENGTH_LONG).show()
                    Log.d("Network", "" + it.message)
                })
        }

        networkBadReqSuspendBtn.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                runCatching {
                    AppNetworkManager.getService().getBadSuspend()
                }.onSuccess {
                    runOnUiThread {
                        Toast.makeText(this@NetworkActivity, "Request successful", Toast.LENGTH_LONG).show()
                    }
                    Log.d("Network", it.string())
                }.onFailure {
                    runOnUiThread {
                        Toast.makeText(this@NetworkActivity, "Request failed", Toast.LENGTH_LONG).show()
                    }
                    Log.d("Network", "" + it.printStackTrace())
                    Log.d("Network", "" + it.message)
                }
            }
        }
    }
}
