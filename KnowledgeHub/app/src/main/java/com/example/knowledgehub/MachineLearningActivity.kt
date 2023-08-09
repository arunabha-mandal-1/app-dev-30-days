package com.example.knowledgehub

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowledgehub.databinding.ActivityMachineLearningBinding

class MachineLearningActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMachineLearningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMachineLearningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMachineLearning.setOnClickListener {
            val phoneNumber = "tel:0123456789"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(phoneNumber)
            startActivity(intent)
        }
    }
}