package com.example.lasttryas3
import android.app.Notification
import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.widget.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name:EditText = findViewById(R.id.name)
        val no:EditText = findViewById(R.id.no)
        val nEXT:Button = findViewById(R.id.NEXT)
        nEXT.setOnClickListener()
        {
            val NAME = name.text.toString()
            val NO = no.text.toString().toInt()
            val myintent=Intent(this,SecondActivity::class.java)
            myintent.putExtra("key",NAME)
            myintent.putExtra("key1",NO)
            startActivity(myintent)
        }
    }
}



//val mapintent: Intent =
////            Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California")
//                .let { location -> Intent(Intent.ACTION_VIEW, location)
//                }
//        startActivity(mapintent)

//        val textMessage : String = "Keef halak"
//        val sendIntent = Intent().apply {
//            action = Intent.ACTION_SEND
//            putExtra(Intent.EXTRA_TEXT, textMessage)
//            type = "text/plain"
//        }
//        try {
//            startActivity(sendIntent)
//        } catch (e:ActivityNotFoundException)
//        {
//            Toast.makeText(this, "no way", Toast.LENGTH_SHORT).show()
//        }