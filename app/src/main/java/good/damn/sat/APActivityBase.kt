package good.damn.sat

import androidx.appcompat.app.AppCompatActivity
import good.damn.sat.tasks.APITask
import good.damn.sat.tasks.APTaskCWE404

class APActivityBase
: AppCompatActivity() {

    private val mTaskActivity: APITask = APTaskCWE404()

    override fun onStart() {
        super.onStart()
        mTaskActivity.execute()
    }

    override fun onStop() {
        super.onStop()
        mTaskActivity.stop()
    }
}

