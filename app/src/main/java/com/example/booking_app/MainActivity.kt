package com.example.booking_app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//image Source: https://www.anantara.com/en/qasr-al-sarab-abu-dhabi?utm_source=GoogleMyBusiness&utm_medium=GMB&utm_term=QasrAlSarab&utm_content=Home&utm_campaign=Google_GMB
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.username)
        val phoneEditText = findViewById<EditText>(R.id.userphone)
        val submit = findViewById<Button>(R.id.btn_login)


        intent?.extras?.let {
            val roomtext = findViewById<TextView>(R.id.room)
            val datetext = findViewById<TextView>(R.id.date)
            val roomnum = it.getString("room")
            val datenum = it.getString("date")
            val nameinet =  it.getString("name")
            val phoneinet =  it.getString("phone")
            nameEditText.setText(nameinet)
            phoneEditText.setText(phoneinet)
            roomtext.setText("Room: "+roomnum)
            roomtext.setVisibility(View.VISIBLE)
            datetext.setText(datenum)
            datetext.setVisibility(View.VISIBLE)
        }
        submit.setOnClickListener{

            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("phone", phone)
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivityForResult(intent,1)
        }


    }
}