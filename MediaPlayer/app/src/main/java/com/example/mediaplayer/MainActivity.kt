package com.example.mediaplayer

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private var totalTime : Int = 0 // Primitive data types cannot be initialized with 'lateinit'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.music_one)
        mediaPlayer.setVolume(1f, 1f)
        totalTime = mediaPlayer.duration

        val play = findViewById<ImageView>(R.id.ivPlay)
        val pause = findViewById<ImageView>(R.id.ivPause)
        val stop = findViewById<ImageView>(R.id.ivStop)
        val seekBarMusic = findViewById<SeekBar>(R.id.seekBar)

        play.setOnClickListener {
            mediaPlayer.start()
        }

        pause.setOnClickListener {
            mediaPlayer.pause()
        }

        stop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.prepare()
        }

        // When user changes the time stamp of music, reflect that change via code
        seekBarMusic.max = totalTime
        seekBarMusic.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    mediaPlayer.seekTo(progress)
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Seekbar position handler
        val handler = Handler()
        handler.postDelayed(object: Runnable{
            override fun run() {
                try {
                    seekBarMusic.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (exception : java.lang.Exception) {
                    seekBarMusic.progress = 0
                }

            }

        }, 0)
    }
}
