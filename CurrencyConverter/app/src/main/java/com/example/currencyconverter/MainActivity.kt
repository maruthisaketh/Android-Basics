package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun convertCurrency(view: View) {
        val currency = findViewById<EditText>(R.id.currencyEditText).text.toString().toInt()
        val newCurrency = currency * 84
        Toast.makeText(this, "$currency$ is Rs.$newCurrency", Toast.LENGTH_SHORT).show()
    }
}