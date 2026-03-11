package good.damn.sat.tasks

import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class APTaskCWE404
: APITask {

    private val outStreams = createStreams(
        createFile(
            "3.mp3"
        )
    )

    private val outStreams2 = createStreams(
        createFile(
            "33.mp3"
        )
    )

    override fun execute() {
        outStreams.forEach { _ -> }
        outStreams2.forEach { _ -> }
        Log.d(
        "TAG",
        "execute: descriptors size:" +
                "${outStreams.size} + ${outStreams2.size}" +
                "= ${outStreams.size + outStreams2.size}"
        )
    }

    override fun stop() = Unit

    private inline fun createFile(
        child: String
    ) = File(
        Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOCUMENTS
        ),
        child
    ).apply {
        if (!exists() && createNewFile()) {  }
    }

    private inline fun createStreams(
        file: File
    ) = Array(
        Short.MAX_VALUE.toInt() / 2
    ) {
        FileOutputStream(
            file
        ).apply {
            close()
        }
    }
}