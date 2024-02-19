package com.example.higherorlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var randomNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomNumber = (1..20).random()
        Log.i("Random number", randomNumber.toString())
    }

    fun higherOrLower(view: View) {
        val number = findViewById<EditText>(R.id.numberEditText).text.toString().toInt()
        if (number > randomNumber) {
            Toast.makeText(this,"Try lower number",Toast.LENGTH_SHORT).show()
        } else if (number < randomNumber) {
            Toast.makeText(this, "Try higher number", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"Correct Guess",Toast.LENGTH_SHORT).show()
            randomNumber = (1..20).random()
        }
    }
}