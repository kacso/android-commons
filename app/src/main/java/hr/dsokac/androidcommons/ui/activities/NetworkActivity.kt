package hr.dsokac.androidcommons.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hr.dsokac.androidcommons.R
import hr.dsokac.androidcommons.extensions.getCurrentLocale
import hr.dsokac.androidcommons.extensions.getSystemLocale
import hr.dsokac.androidcommons.logger.log
import hr.dsokac.androidcommons.network.managers.AppNetworkManager
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_network.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NetworkActivity : AppCompatActivity() {
    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, NetworkActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_network)

        networkReqSingleBtn.setOnClickListener {
            AppNetworkManager.getService().getSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Toast.makeText(this, "Request successful", Toast.LENGTH_LONG).show()
                    log("Network", it.string())
                }, {
                    Toast.makeText(this, "Request failed", Toast.LENGTH_LONG).show()
                    log("Network", "" + it.message)
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
                    log("Network", it.string())
                }.onFailure {
                    runOnUiThread {
                        Toast.makeText(this@NetworkActivity, "Request failed", Toast.LENGTH_LONG).show()
                    }
                    log("Network", "" + it.message)
                }
            }
        }

        networkBadReqSingleBtn.setOnClickListener {
            AppNetworkManager.getService().getBadSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Toast.makeText(this, "Request successful", Toast.LENGTH_LONG).show()
                    log("Network", it.string())
                }, {
                    Toast.makeText(this, "Request failed", Toast.LENGTH_LONG).show()
                    log("Network", "" + it.message)
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
                    log("Network", it.string())
                }.onFailure {
                    runOnUiThread {
                        Toast.makeText(this@NetworkActivity, "Request failed", Toast.LENGTH_LONG).show()
                    }
                    log("Network", "" + it.printStackTrace())
                    log("Network", "" + it.message)
                }
            }
        }

        currentLocale.text = getCurrentLocale().language
        systemLocale.text = getSystemLocale().language
    }
}
