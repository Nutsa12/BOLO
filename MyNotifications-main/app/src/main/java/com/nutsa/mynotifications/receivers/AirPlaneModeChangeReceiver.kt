package com.nutsa.mynotifications.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.nutsa.mynotifications.notifications.NotificationUtil

class AirPlaneModeChangeReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val airplaneEnabled = intent?.getBooleanExtra("state", false) ?: return

        if(airplaneEnabled){
            NotificationUtil.showNotification(context!!, "Airplane mode enabled")
            Toast.makeText(context, "Enabled", Toast.LENGTH_LONG).show()
            return
        }
        NotificationUtil.showNotification(context!!, "Airplane mode disabled")
        Toast.makeText(context, "Disabled", Toast.LENGTH_LONG).show()
    }

}