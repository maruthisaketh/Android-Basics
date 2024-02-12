package com.example.interactivitydemo

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

    fun clickFunction(view: View) {
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        Log.i("Name", nameEditText.text.toString())
    }
}