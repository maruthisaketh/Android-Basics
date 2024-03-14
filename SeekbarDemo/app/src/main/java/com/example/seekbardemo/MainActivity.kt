package com.example.seekbardemo

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var volSeekbar: SeekBar
    private lateinit var scrubSeekBar: SeekBar
    private lateinit var audioManager: AudioManager


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        
        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager

        val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.audio)

        volSeekbar = findViewById(R.id.volumeSeekbar)
        volSeekbar.max = maxVolume
        volSeekbar.progress = currentVolume

        scrubSeekBar = findViewById(R.id.scrubSeekbar)
        scrubSeekBar.max = mediaPlayer.duration
        scrubSeekBar.progress = 0

        volSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        scrubSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mediaPlayer.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                mediaPlayer.pause()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                mediaPlayer.start()
            }

        })

        val timer = Timer()
        timer.scheduleAtFixedRate(object: TimerTask() {
            override fun run() {
                scrubSeekBar.progress = mediaPlayer.currentPosition
            }

        }, 0, 500)

    }

    fun play(view: View) {
        mediaPlayer.start()
    }

    fun pause(view: View) {
        mediaPlayer.pause()
    }
}