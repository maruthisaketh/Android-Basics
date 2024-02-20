package com.example.fadinganimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private var bartIsShowing = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fade(view: View) {
        val imageView = findViewById<ImageView>(R.id.imageView)
        val homerImageView = findViewById<ImageView>(R.id.homerImageView)

        bartIsShowing = if (bartIsShowing) {
            imageView.animate().alpha(0.0F).setDuration(2000)
            homerImageView.animate().alpha(1.0F).setDuration(2000)
            false
        } else {
            imageView.animate().alpha(1.0F).setDuration(2000)
            homerImageView.animate().alpha(0.0F).setDuration(2000)
            true
        }

    }
}