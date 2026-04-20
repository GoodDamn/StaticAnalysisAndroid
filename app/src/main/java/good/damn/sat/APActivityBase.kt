package good.damn.sat

import androidx.appcompat.app.AppCompatActivity
import good.damn.sat.tasks.APITask
import good.damn.sat.tasks.APTaskCWE190CWE191
import good.damn.sat.tasks.APTaskCWE427

class APActivityBase
: AppCompatActivity() {

    private val mTaskActivity: APITask = APTaskCWE427(
        this
    )

    override fun onStart() {
        super.onStart()
        mTaskActivity.execute()
    }

    override fun onStop() {
        super.onStop()
        mTaskActivity.stop()
    }
}

