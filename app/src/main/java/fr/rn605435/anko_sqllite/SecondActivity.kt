package fr.rn605435.anko_sqllite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.info
import org.jetbrains.anko.uiThread

class SecondActivity : AppCompatActivity(), AnkoLogger {
    val courseDb by lazy { CourseDb(CourseDbHelper(applicationContext)) }
    var list = listOf<MobileCourse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        doAsync {
            val course = MobileCourse("ABC Android",120)

            courseDb.saveCourse(course)
            list = courseDb.requestCourse()
            uiThread {
                showList()
            }
        }
    }
    private fun showList() {
        info("NB COURS : ${list.size}")
        for (c in list)
            info("Voici un cours ${c.title}")
    }
}
