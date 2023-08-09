package com.example.photoframeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoframeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val photos = listOf(R.drawable.pic0, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3)
    private val names = arrayOf("Red Boy", "Mickey Mouse", "Teddy", "Lion")
    private var currentPhotoIndex = 0

    // 1 2 3 4| 1 2 3 4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imgCartoon.setImageResource(photos[currentPhotoIndex])
        binding.tvCartoon.text = names[currentPhotoIndex]

        binding.imgPrev.setOnClickListener {
            showPrevPhoto()
        }

        binding.imgNext.setOnClickListener {
            showNextPhoto()
        }
    }

    private fun showPrevPhoto() {
        currentPhotoIndex = (photos.size + currentPhotoIndex - 1) % photos.size
        binding.imgCartoon.setImageResource(photos[currentPhotoIndex])
        binding.tvCartoon.text = names[currentPhotoIndex]
    }

    private fun showNextPhoto() {
        currentPhotoIndex = (currentPhotoIndex + 1) % photos.size
        binding.imgCartoon.setImageResource(photos[currentPhotoIndex])
        binding.tvCartoon.text = names[currentPhotoIndex]
    }
}
