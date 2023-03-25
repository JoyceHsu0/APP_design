package com.example.booking_app

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.booking_app.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*


class MainActivity2 : AppCompatActivity() {

    private lateinit var btncheckin: Button
    private lateinit var btncheckout: Button
    private lateinit var txtcheckin: TextView
    private lateinit var txtcheckout: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = PageAdapter(supportFragmentManager)


        val tabLayout = findViewById<TabLayout>(R.id.tablayout)
        tabLayout.setupWithViewPager(viewPager)

        btncheckin = findViewById(R.id.btncheckin)
        btncheckout = findViewById(R.id.btncheckout)
        txtcheckin = findViewById(R.id.txtcheckin)
        txtcheckout = findViewById(R.id.txtcheckout)

        //take year and month and day from calender
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        var checkin = txtcheckin.text.toString()
        var checkout =txtcheckout.text.toString()
        //on button click open date picker

        val handler = Handler()
        btncheckin.setOnClickListener{
            Thread(Runnable {
                handler.post(Runnable {
                    val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, myear, mmonth, mday ->
                        txtcheckin.text = "${mmonth+1} / $mday"
                        checkin ="${mmonth+1} / $mday"
                    }, year, month, day).show()

                })

            }).start()

        }
        btncheckout.setOnClickListener{
            Thread(Runnable {
                handler.post(Runnable {
                    val dpd2 = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, m2year, m2month, m2day ->
                        txtcheckout.text = "${m2month+1} / $m2day"
                        checkout ="${m2month+1} / $m2day"
                    }, year, month, day).show()

                })

            }).start()

        }

        //println(viewPager.getCurrentItem())
        var roomnum = ""
        val submit = findViewById<Button>(R.id.btn_submit)
        submit.setOnClickListener{
            println(viewPager.getCurrentItem())
            when(viewPager.getCurrentItem()) {
                0 -> {
                    roomnum = "Terrace Room"
                }
                1 -> {
                    roomnum = "Oasis Suite"
                }
                2 -> {
                    roomnum = "Family Pool Villa"
                }
                3 -> {
                    roomnum = "Oasis Villa"
                }
            }
            println(roomnum)
            intent?.extras?.let {
                val name = it.getString("name")
                val phone = it.getString("phone")

                val bundle = Bundle()
                bundle.putString("room", roomnum)
                bundle.putString("date", checkin + " ~ " + checkout)
                bundle.putString("name", name)
                bundle.putString("phone", phone)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtras(bundle)
                startActivityForResult(intent,1)
                /*setResult(Activity.RESULT_OK, intent.putExtras(bundle))
                finish()*/
            }
        }

    }



}


