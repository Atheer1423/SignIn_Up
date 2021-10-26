package com.example.signin_up

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Context

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class dbhelper(context: Context) : SQLiteOpenHelper(context,"users.db",null,1) {
    var sqLiteDatabase: SQLiteDatabase = writableDatabase
    var s = SignIn()
    var retriveName = " "
    var retriveLoc = " "
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table user (name text ,mobile text, location text , password text )")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
    fun addUser(name: String, mobile: String, location: String, password: String) {

        val cv = ContentValues()
        cv.put("name", name)
        cv.put("mobile", mobile)
        cv.put("location", location)
        cv.put("password", password)
        sqLiteDatabase.insert("user", null, cv)
    }

    @SuppressLint("Range")
    fun retriveUser(mobile: String, pass: String) {
        var c: Cursor = sqLiteDatabase.query(
            "user", null, "mobile=?",
            arrayOf(mobile), null, null, null
        )
        c.moveToFirst()
        if (c != null && c.moveToFirst()) {
            var retrivepass = c.getString(c.getColumnIndex("password"))

            Log.d("name", "in if1")
            if (retrivepass == pass) {
                Log.d("name", "if 2")
                retriveName = c.getString(c.getColumnIndex("name"))
                retriveLoc = c.getString(c.getColumnIndex("location"))
                Log.d("name", retriveName)
                Log.d("name", retriveLoc)
            } else {
                Toast.makeText(s.applicationContext, "mobile or pass wrong", Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            Log.d("NoUser", "NoUser")
        }
        Log.d("f",retriveName)
        Log.d("f", retriveLoc)


    }
}