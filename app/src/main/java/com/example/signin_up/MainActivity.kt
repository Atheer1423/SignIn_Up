package com.example.signin_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var signinB: TextView
    lateinit var signupB:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signinB=findViewById(R.id.si)
        signupB=findViewById(R.id.su)

        signinB.setOnClickListener {
            var intent= Intent(this,SignIn::class.java)
            startActivity(intent);
        }
        signupB.setOnClickListener {
            var intent= Intent(this,SignUp::class.java)
            startActivity(intent);
        }
    }
}