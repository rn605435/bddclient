package fr.rn605435.anko_sqllite

import android.app.Application
import android.content.res.Resources

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
