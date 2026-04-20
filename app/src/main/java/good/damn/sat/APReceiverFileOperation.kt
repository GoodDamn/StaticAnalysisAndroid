package good.damn.sat

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.File

class APReceiverFileOperation
: BroadcastReceiver() {
    companion object {
        private const val TAG = "APReceiverFileOperation"
        const val KEY = "someMessage"
        const val ACTION = "receiver.action"
    }

    override fun onReceive(
        context: Context?,
        intent: Intent?
    ) {
        intent ?: return
        context ?: return

        val localPath = intent.getStringExtra(
            "someMessage"
        )

        Log.d(TAG, "onReceive: $localPath")

        val dir = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOCUMENTS
        )

        val file = File(
            dir,
            localPath
        )

        if (!file.exists() && file.createNewFile()) {
            Log.d(TAG, "onReceive: ${file.path} is created")
        }

        /*if (file.delete()) {
            Log.d(TAG, "onReceive: ${file.name} is deleted")
        }*/
    }
}