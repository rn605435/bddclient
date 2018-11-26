package fr.rn605435.anko_sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class CourseDbHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "MyDatabase", null, 1) {
    companion object {
        private var instance: CourseDbHelper? = null
        @Synchronized
        fun getInstance(ctx: Context): CourseDbHelper {
            if (instance == null) {
                instance = CourseDbHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }
    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(MobileCourseTable.NAME, true, MobileCourseTable.ID to INTEGER + PRIMARY_KEY+ UNIQUE,
                MobileCourseTable.TITLE to TEXT,
                MobileCourseTable.TIME to INTEGER
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(MobileCourseTable.NAME, true)
        onCreate(db)
    }
    val Context.database: CourseDbHelper
        get() = CourseDbHelper.getInstance(getApplicationContext())

}
