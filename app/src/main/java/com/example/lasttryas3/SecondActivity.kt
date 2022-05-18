package com.example.lasttryas3

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.*
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class SecondActivity : AppCompatActivity() {
    private val CHANNEL_ID = " channel_id_example_01"
    private val notificationID = 101
    private fun createNotificationChannel()
    {
if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
{
    val name = "Notification Title"
    val descriptionText = "Notification Description"
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val channel = NotificationChannel(CHANNEL_ID,name,importance).apply {
        description=descriptionText
    }
    val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(channel)
}
    }
    private fun DrawNotification()
    {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent:PendingIntent =  PendingIntent.getActivity(this, 0, intent, 0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.icon2)
        val bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.icon1)





        val builder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable
                .ic_launcher_foreground)
            .setContentTitle("Notification")
            .setContentText("Notification")
            .setLargeIcon(bitmapLargeIcon)
           .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
           with(NotificationManagerCompat.from(this))
           {
               notify(notificationID,builder.build())

           }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
       val button:Button = findViewById(R.id.button)
        createNotificationChannel()
        button.setOnClickListener{
            DrawNotification()
        }
        val WC:TextView = findViewById(R.id.WC)
     val bundle:Bundle? = intent.extras
        bundle?.let {
            val nm = bundle.getString("key")
            val no1 = bundle.getInt("key1")
            WC.text = "Hello \n" + nm + "\n Your Student ID is \n" + no1
            Toast.makeText(this,"your Second Activity is Launched",Toast.LENGTH_LONG).show()

        }

    }


}