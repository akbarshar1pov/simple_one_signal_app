package com.sharipov.onesignal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.onesignal.OneSignal


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.login).setOnClickListener {
            OneSignal.login("USER_ID")
            showToast("Login clicked")
        }

        findViewById<Button>(R.id.logout).setOnClickListener {
            OneSignal.logout()
            showToast("Logout clicked")
        }

        findViewById<Button>(R.id.enable_push).setOnClickListener {
            OneSignal.User.pushSubscription.optIn()
            showToast("Push enabled")
        }

        findViewById<Button>(R.id.disable_push).setOnClickListener {
            OneSignal.User.pushSubscription.optOut()
            showToast("Push disabled")
        }

        findViewById<Button>(R.id.prompt_push).setOnClickListener {
            OneSignal.InAppMessages.addTrigger("show_push_permission_prompt", "1")
            showToast("Push permission prompt shown")
        }

        findViewById<Button>(R.id.present_iam).setOnClickListener {
            OneSignal.InAppMessages.addTrigger("show_sample_iam", "1")
            showToast("Sample In-App Message shown")
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}