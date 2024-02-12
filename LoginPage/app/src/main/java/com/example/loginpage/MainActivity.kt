package com.example.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun loginClicked(view: View) {
        val username = findViewById<EditText>(R.id.usernameEditView)
        val password = findViewById<EditText>(R.id.passwordEditView)
        Log.i("Username", username.text.toString())
        Log.i("Password", password.text.toString())
    }
}