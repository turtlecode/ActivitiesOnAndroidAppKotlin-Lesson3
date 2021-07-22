package com.turtlecode.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = "Welcome to application!"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
    fun go_second_activity (view : View) {
        val alert = AlertDialog.Builder(this)
        alert.setMessage("Are you sure to go second activity?")

        alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            val text = "You're going to second activity"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext,text, duration)
            toast.show()
            val name_text = name_text.text.toString()
            val surname_text = surname_text.text.toString()
            val intent = Intent(applicationContext, MainActivity2::class.java)
            intent.putExtra("name",name_text)
            intent.putExtra("surname",surname_text)
            Thread.sleep(2000)
            startActivity(intent)
            finish()
        })
        alert.setNegativeButton("No") {DialogInterface, i ->
            val text = "You'll stay here!"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext,text, duration)
            toast.show()
        }
        alert.show()
    }
}