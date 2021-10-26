package com.example.signin_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class details : AppCompatActivity() {
    lateinit var nameTV:TextView
    lateinit var mobileTV:TextView
    lateinit var locationTV:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)
        nameTV=findViewById(R.id.nameTV)
        mobileTV=findViewById(R.id.mobileTv)
        locationTV=findViewById(R.id.locTv)
        var n=intent.extras?.get("name")
        var l=intent.extras?.get("location")
        var m=intent.extras?.get("mobile")
        nameTV.text=n.toString()
        mobileTV.text=m.toString()
        locationTV.text=l.toString()
    }
}