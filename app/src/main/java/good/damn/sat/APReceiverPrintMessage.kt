package good.damn.sat

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class APReceiverPrintMessage
: BroadcastReceiver() {
    companion object {
        const val KEY = "someMessage"
        const val ACTION = "receiver.action"
    }

    override fun onReceive(
        context: Context?,
        intent: Intent?
    ) {
        intent ?: return
        context ?: return

        val msg = intent.getStringExtra(
            KEY
        )

        Toast.makeText(
            context,
            "Message is $msg on ${intent.action}",
            Toast.LENGTH_LONG
        ).show()
    }
}