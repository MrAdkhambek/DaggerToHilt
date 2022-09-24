package me.adkhambek.dh.app

import android.app.Application
import me.adkhambek.dh.di.component.ApplicationComponent
import me.adkhambek.dh.di.component.DaggerApplicationComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent
            .factory()
            .create(this)
    }
}