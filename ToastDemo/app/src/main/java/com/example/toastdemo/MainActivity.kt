package com.example.toastdemo

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

    fun sayHello(view: View) {
        val name = findViewById<EditText>(R.id.nameEditView)
        Toast.makeText(this, "Hello " + name.text.toString() + "!", Toast.LENGTH_SHORT).show()
    }
}