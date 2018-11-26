package fr.rn605435.anko_sqllite

import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class CourseDb(private val dbHelper: CourseDbHelper) {

    fun requestCourse() = dbHelper.use {
        select(MobileCourseTable.NAME,
                MobileCourseTable.TITLE, MobileCourseTable.TIME)
                .parseList(classParser<MobileCourse>())
    }

    fun saveCourse(course: MobileCourse) = dbHelper.use {
    insert(MobileCourseTable.NAME,
            MobileCourseTable.TITLE to course.title,
            MobileCourseTable.TIME to course.time)
    }
    fun saveCourses(courses: List<MobileCourse>) {
        for (c in courses)
            saveCourse(c)
    }
}
