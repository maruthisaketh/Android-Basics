package com.example.videodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.videoView)

        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)

        videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.video)
        videoView.setMediaController(mediaController)
        videoView.start()


    }
}