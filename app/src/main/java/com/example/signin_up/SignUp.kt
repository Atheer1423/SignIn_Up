package com.example.signin_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    lateinit var nameET: EditText
    lateinit var mobileET: EditText
    lateinit var locationET: EditText
    lateinit var passET: EditText
    lateinit var suB: Button
    lateinit var db:dbhelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sgn_up)
db=dbhelper(this)
        nameET=findViewById(R.id.nameET)
        mobileET=findViewById(R.id.mobileEt)
        locationET=findViewById(R.id.locET)
        passET=findViewById(R.id.passwordET)
        suB=findViewById(R.id.suB)
        suB.setOnClickListener { AddToDB() }
    }
    fun AddToDB() {
        db.addUser(nameET.text.toString(),mobileET.text.toString(),locationET.text.toString(),passET.text.toString())
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
        var intent= Intent(this,details::class.java)
        intent.putExtra("name","Welcome ${nameET.text}")
        intent.putExtra("mobile",mobileET.text.toString())
        intent.putExtra("location",locationET.text.toString())
        startActivity(intent)
    }
}