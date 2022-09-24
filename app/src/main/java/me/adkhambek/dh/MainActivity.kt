package me.adkhambek.dh

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject
import me.adkhambek.dh.app.App

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (applicationContext as App).appComponent
        val activityComponent = appComponent.activityComponent.activity(this).build()
        activityComponent.inject(this)

        val textView = findViewById<TextView>(R.id.text_view)
        textView.text = appName
    }
}