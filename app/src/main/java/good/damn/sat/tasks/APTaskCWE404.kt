package good.damn.sat.tasks

import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class APTaskCWE404
: APITask {

    companion object {
        private const val TAG = "APTaskCWE404"
    }

    private val mFile = File(
        Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOCUMENTS
        ),
        "3.mp3"
    ).apply {
        if (!exists() && createNewFile()) {
            Log.d(TAG, "execute: $name is created")
        }
    }

    private val mFile2 = File(
        Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOCUMENTS
        ),
        "33.mp3"
    ).apply {
        if (!exists() && createNewFile()) {
            Log.d(TAG, "execute: $name is created")
        }
    }

    private val outStreams = Array(
        Short.MAX_VALUE.toInt() / 2
    ) {
        FileOutputStream(
            mFile
        )
    }

    private val outStreams2 = Array(
        Short.MAX_VALUE.toInt() / 2
    ) {
        FileOutputStream(
            mFile2
        )
    }

    override fun execute() {
        outStreams.forEach { _ -> }
        outStreams2.forEach { _ -> }
    }

    override fun stop() = Unit
}