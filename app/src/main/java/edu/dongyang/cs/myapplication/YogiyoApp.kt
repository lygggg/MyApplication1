package edu.dongyang.cs.myapplication

import android.app.Application
import com.facebook.stetho.Stetho

class YogiyoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
    }
}



