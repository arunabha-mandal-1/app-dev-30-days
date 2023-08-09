package com.example.knowledgehub

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowledgehub.databinding.ActivityIosDevBinding

class IosDevActivity : AppCompatActivity() {
    private lateinit var binding : ActivityIosDevBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIosDevBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIos.setOnClickListener {
            val phoneNumber = "tel:0123456789"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(phoneNumber)
            startActivity(intent)
        }
    }
}