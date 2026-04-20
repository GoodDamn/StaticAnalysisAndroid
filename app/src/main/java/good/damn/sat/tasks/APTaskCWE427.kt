package good.damn.sat.tasks

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import good.damn.sat.APReceiverFileOperation

class APTaskCWE427(
    private val activity: AppCompatActivity
): APITask {

    private val mReceiverFile = APReceiverFileOperation()

    override fun execute() {
        val appContext = activity.applicationContext

        ContextCompat.registerReceiver(
            appContext,
            mReceiverFile,
            IntentFilter().apply {
                addAction(
                    APReceiverFileOperation.ACTION
                )
            },
            ContextCompat.RECEIVER_EXPORTED
        )
    }

    override fun stop() {
        activity.unregisterReceiver(
            mReceiverFile
        )
    }

}