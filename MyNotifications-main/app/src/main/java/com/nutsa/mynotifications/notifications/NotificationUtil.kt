package com.nutsa.mynotifications.notifications

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.nutsa.mynotifications.R

object NotificationUtil {
    const val CHANNEL_ID = "NutsaChannel"
    private var notificationID = 1

    fun showNotification(context: Context, text: String){
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
            .setContentTitle("Airplane Mode Changed")
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(notificationID++, notification.build())
    }
}