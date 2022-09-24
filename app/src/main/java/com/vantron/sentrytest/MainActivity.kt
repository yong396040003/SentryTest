package com.vantron.sentrytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vantron.sentry.SentryUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}