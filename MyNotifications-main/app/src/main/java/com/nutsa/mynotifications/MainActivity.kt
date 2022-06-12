package com.nutsa.mynotifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nutsa.mynotifications.databinding.ActivityMainBinding
import com.nutsa.mynotifications.notifications.NotificationUtil
import com.nutsa.mynotifications.receivers.AirPlaneModeChangeReceiver

class MainActivity : AppCompatActivity() {
    private lateinit var airPlaneModeChangeReceiver: AirPlaneModeChangeReceiver
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createChannel()

        airPlaneModeChangeReceiver = AirPlaneModeChangeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airPlaneModeChangeReceiver, it)
        }

        binding.myButton.setOnClickListener{
            Toast.makeText(this, "Airplane", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val something = NotificationChannel(NotificationUtil.CHANNEL_ID, NotificationUtil.CHANNEL_ID,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                    description = "Airplane Notification"
            }

            val manager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(lasha)
        }
    }
}