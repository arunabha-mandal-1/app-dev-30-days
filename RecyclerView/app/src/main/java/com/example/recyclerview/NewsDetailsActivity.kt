package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val heading = intent.getStringExtra("heading")
        val imageId = intent.getIntExtra("imageId", R.drawable.img1)
        val newsContent = intent.getStringExtra("newsContent")

        val headingImg = findViewById<ImageView>(R.id.ivHeading)
        val headingText = findViewById<TextView>(R.id.tvHeading)
        val newsDetails = findViewById<TextView>(R.id.tvNewsDetails)

        headingText.text = heading
        headingImg.setImageResource(imageId)
        newsDetails.text = newsContent
    }
}