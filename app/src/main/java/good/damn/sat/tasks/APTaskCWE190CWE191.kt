package good.damn.sat.tasks

import android.util.Log

class APTaskCWE190CWE191
: APITask {
    override fun execute() {
        val i = Int.MAX_VALUE // 2147483647 (CWE-190)
        Log.d("TAG", "execute: MAX_VALUE: ${i + 1}")
        val j = Int.MIN_VALUE // -2147483648 (CWE-191)
        Log.d("TAG", "execute: MIN_VALUE: ${j - 1}")
    }
    override fun stop() = Unit
}