package good.damn.sat.tasks

import android.os.Environment
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.random.Random

class APTaskCWE125CWE787
: APITask {
    private val inputStream = FileInputStream(
        createFile(
            "33.mp3"
        )
    )
    private val outStream = FileOutputStream(
        createFile(
            "33.mp3"
        )
    )
    override fun execute() {
        repeat(6) {
            val buffer = Random.nextBytes(1024)
            outStream.write( // CWE-787
                buffer,
                0,
                buffer.size + 1
            )
        }
        outStream.close()

        val buffer = ByteArray(1024)
        repeat(6) { // CWE-125
            inputStream.read(
                buffer,
                buffer.size,
                1
            )
        }
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
}