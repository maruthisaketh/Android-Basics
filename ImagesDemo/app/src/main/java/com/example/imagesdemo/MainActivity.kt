package com.example.imagesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeCat(view: View) {
        val catImage = findViewById<ImageView>(R.id.catImageView)
        catImage.setImageResource(R.drawable.cat2)
    }
}