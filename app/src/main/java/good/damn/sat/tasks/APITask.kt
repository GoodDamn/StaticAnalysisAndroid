package good.damn.sat.tasks

import androidx.appcompat.app.AppCompatActivity

interface APITask {
    fun execute()
    fun stop()
}