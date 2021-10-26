package com.example.signin_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
class SignIn : AppCompatActivity() {
    lateinit var mobile: EditText
    lateinit var pass: EditText
    lateinit var si: Button
    lateinit var db: dbhelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)

        db = dbhelper(this)
        Log.d("name", "create db")
        mobile = findViewById(R.id.mobET)
        pass = findViewById(R.id.passET)
        si = findViewById(R.id.siB)
        si.setOnClickListener {
            Log.d("name", "click si")
            db.retriveUser(mobile.text.toString(), pass.text.toString())
        }
    }

    fun userFound(name: String, loc: String) {
        Log.d("name", "in user found")
        var intent = Intent(this, details::class.java)
        Log.d("name", "intent")
        intent.putExtra("name", "Welcome $name")
        intent.putExtra("mobile", mobile.text.toString())
        intent.putExtra("location", loc)
        startActivity(intent)
    }
}