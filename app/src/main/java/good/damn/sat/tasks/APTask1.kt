package good.damn.sat.tasks

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import good.damn.sat.APReceiverPrintMessage

class APTask1(
    private val activity: AppCompatActivity
): APITask {

    private val mReceiverСonnected = APReceiverPrintMessage()

    override fun execute() {
        val appContext = activity.applicationContext

        ContextCompat.registerReceiver(
            appContext,
            mReceiverСonnected,
            IntentFilter().apply {
                addAction(
                    Intent.ACTION_POWER_CONNECTED
                )

                addAction(
                    Intent.ACTION_POWER_DISCONNECTED
                )

                addAction(
                    APReceiverPrintMessage.ACTION
                )
            },
            ContextCompat.RECEIVER_NOT_EXPORTED
        )

        appContext.sendBroadcast(
            Intent().putExtra(
                APReceiverPrintMessage.KEY,
                "Implicit"
            ).setAction(
                APReceiverPrintMessage.ACTION
            ).setPackage(
                activity.packageName
            )
        )
    }

    override fun stop() {
        activity.unregisterReceiver(
            mReceiverСonnected
        )
    }

}