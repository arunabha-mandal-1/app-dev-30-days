package com.example.knowledgehub

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowledgehub.databinding.ActivityDevopsBinding

class DevopsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDevopsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDevopsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDevops.setOnClickListener {
            val phoneNumber = "tel:0123456789"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(phoneNumber)
            startActivity(intent)
        }
    }
}